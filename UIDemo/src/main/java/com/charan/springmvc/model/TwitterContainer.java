package com.charan.springmvc.model;

public class TwitterContainer {

	private String id;

	private String appName;

	private boolean start;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TwitterContainer() {

	}

	public TwitterContainer(String containerId, String appName, boolean status) {
		this.id = containerId;
		this.appName = appName;
		this.start = status;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

}
