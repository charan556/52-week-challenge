package com.charan.springmvc.service;

import java.util.List;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerClient.ListContainersParam;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.AuthConfig;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ContainerInfo;

public class DockerService {

	public static void startContainer(String containerId) {
		try {
			DockerClient docker = DefaultDockerClient.fromEnv().build();
			docker.startContainer(containerId);
		} catch (DockerException | InterruptedException | DockerCertificateException e) {
			e.printStackTrace();
		}
	}

	public static void stopContainer(String containerId) {
		try {
			DockerClient docker = DefaultDockerClient.fromEnv().build();
			docker.stopContainer(containerId, 10);
		} catch (DockerException | InterruptedException | DockerCertificateException e) {
			e.printStackTrace();
		}
	}

	public static void reStartContainer() {
		try {
			DockerClient docker = DefaultDockerClient.fromEnv().build();
			List<Container> list = docker.listContainers(ListContainersParam.withLabel("hadoop"));
			for (Container container : list) {
				docker.restartContainer(container.id(), 10);
			}
		} catch (DockerException | InterruptedException | DockerCertificateException e) {
			e.printStackTrace();
		}
	}

	public static void listContainerInfo(String id) {
		DockerClient docker = null;
		try {
			docker = DefaultDockerClient.fromEnv().build();
		} catch (DockerCertificateException e1) {
			e1.printStackTrace();
		}
		ContainerInfo info = null;
		try {
			info = docker.inspectContainer(id);
		} catch (DockerException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(info.toString());
	}

	public static String buildContainer(String image, String tagName) {
		DockerClient docker = null;
		try {
			docker = DefaultDockerClient.fromEnv().build();
		} catch (DockerCertificateException e1) {
			e1.printStackTrace();
		}
		try {
			AuthConfig authConfig = AuthConfig.builder().email("charan.cse@gmail.com").username("charan556")
					.password("charan123#").build();
			docker = DefaultDockerClient.fromEnv().authConfig(authConfig).build();
			docker.pull(image);

			final ContainerConfig config = ContainerConfig.builder().image(image).build();
			final ContainerCreation container = docker.createContainer(config, tagName);
			// docker.startContainer(container.id());
			return container.id();

		} catch (DockerException | InterruptedException e1) {
			e1.printStackTrace();
		} catch (DockerCertificateException e) {
			e.printStackTrace();
		}
		return null;

	}
}
