package com.ElectricityAccountServiceClient.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * ElectricityAccountClient is the client for ElectricityAccountService
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

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
