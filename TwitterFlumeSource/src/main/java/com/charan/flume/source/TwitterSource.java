package com.charan.flume.source;

import java.util.HashMap;
import java.util.Map;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.channel.ChannelProcessor;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

public class TwitterSource extends AbstractSource implements EventDrivenSource, Configurable {

	private static final Logger logger = LoggerFactory.getLogger(TwitterSource.class);

	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;

	private String[] keywords;

	private TwitterStream twitterStream;

	public void configure(Context context) {
		consumerKey = context.getString(TwitterSourceConstants.CONSUMER_KEY_KEY);
		consumerSecret = context.getString(TwitterSourceConstants.CONSUMER_SECRET_KEY);
		accessToken = context.getString(TwitterSourceConstants.ACCESS_TOKEN_KEY);
		accessTokenSecret = context.getString(TwitterSourceConstants.ACCESS_TOKEN_SECRET_KEY);

		String keywordString = context.getString(TwitterSourceConstants.KEYWORDS_KEY, "");
		if (keywordString.trim().length() == 0) {
			keywords = new String[0];
		} else {
			keywords = keywordString.split(",");
			for (int i = 0; i < keywords.length; i++) {
				keywords[i] = keywords[i].trim();
			}
		}

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey(consumerKey);
		cb.setOAuthConsumerSecret(consumerSecret);
		cb.setOAuthAccessToken(accessToken);
		cb.setOAuthAccessTokenSecret(accessTokenSecret);
		cb.setJSONStoreEnabled(true);
		cb.setIncludeEntitiesEnabled(true);

		twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
	}

	@Override
	public void start() {

		final ChannelProcessor channel = getChannelProcessor();

		final Map<String, String> headers = new HashMap<String, String>();

		StatusListener listener = new StatusListener() {
			// The onStatus method is executed every time a new tweet comes in.
			public void onStatus(Status status) {
				// The EventBuilder is used to build an event using the headers
				// and the raw JSON of a tweet shouldn't log possibly sensitive
				// customer data
				logger.debug("tweet arrived");

				headers.put("timestamp", String.valueOf(status.getCreatedAt().getTime()));
				Event event = EventBuilder.withBody(DataObjectFactory.getRawJSON(status).getBytes(), headers);

				channel.processEvent(event);
			}

			// This listener will ignore everything except for new tweets
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onScrubGeo(long userId, long upToStatusId) {
			}

			public void onException(Exception ex) {
			}

			public void onStallWarning(StallWarning warning) {
			}
		};

		logger.debug("Setting up Twitter sample stream using consumer key {} and" + " access token {}",
				new String[] { consumerKey, accessToken });

		// Set up the stream's listener (defined above),
		twitterStream.addListener(listener);

		// Set up a filter to pull out industry-relevant tweets
		if (keywords.length == 0) {
			logger.debug("Starting up Twitter sampling...");
			twitterStream.sample();
		} else {
			logger.debug("Starting up Twitter filtering...");

			FilterQuery query = new FilterQuery().track(keywords);
			twitterStream.filter(query);
		}
		super.start();
	}

	/**
	 * Stops the Source's event processing and shuts down the Twitter stream.
	 */
	@Override
	public void stop() {
		logger.debug("Shutting down Twitter sample stream...");
		twitterStream.shutdown();
		super.stop();
	}
}
