package com.ElectricityAccountServiceClient.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ElectrictyAccountClient {
	private static String baseURI = "http://localhost:8080/ElectricityAccount/myService/hello";

	public static void main(String[] args) {
		testGet();
	}

	static void testGet() {
		WebResource resource = getWebResource();

		String output = resource.get(String.class);

		System.out.println(output);
	}

	static WebResource getWebResource() {
		Client client = Client.create();
		WebResource resource = client.resource(baseURI);

		return resource;
	}
}
