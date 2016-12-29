package com.charan.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.charan.springmvc.model.TwitterContainer;
import com.charan.springmvc.service.TwitterService;

@RestController
public class TwitterController {

	@Autowired
	TwitterService twitterService;

	@RequestMapping(value = "/twitter/list", method = RequestMethod.GET)
	public ResponseEntity<List<TwitterContainer>> listAllUsers() {
		List<TwitterContainer> containers = twitterService.findAllContainers();
		if (containers.isEmpty()) {
			return new ResponseEntity<List<TwitterContainer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TwitterContainer>>(containers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/twitter/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createTwitterAnalysis(@RequestBody TwitterContainer app,
			UriComponentsBuilder ucBuilder) {

		twitterService.startAnalysis(app);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(app.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}