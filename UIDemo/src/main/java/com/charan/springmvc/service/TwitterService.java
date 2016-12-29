package com.charan.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.charan.springmvc.model.TwitterContainer;

@Service
public class TwitterService {

	List<TwitterContainer> containers;

	public TwitterService() {
		containers = new ArrayList<>();
	}

	public void startAnalysis(TwitterContainer app) {
		String containerId = DockerService.buildContainer("charan556/hadoop-docker", "myHadoop-" + app.getAppName());
		DockerService.startContainer(containerId);
		containers.add(new TwitterContainer(containerId, "hadoop", true));
		System.out.println("Container started .... with ID " + containerId);
		System.out.println(ShellAgent.executeCommand("docker ps"));
	}

	public List<TwitterContainer> findAllContainers() {
		return containers;
	}

	public List<TwitterContainer> refreshList() {
		for (TwitterContainer twitterContainer : containers) {
			DockerService.listContainerInfo(twitterContainer.getId());
		}
		return null;
	}

}
