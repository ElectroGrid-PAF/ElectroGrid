package com.ElectricityAccountServiceClient.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * ElectricityAccountClient is the client for ElectricityAccountService
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */


@Path("/Accounts")
public class ElectrictyAccountClient {
	private static String baseURI = "http://localhost:8080/ElectricityAccount/AccountService/Accounts";

	// Retrieve all electricity accounts
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String testGet() {
		WebResource resource = getWebResource();
		String output = resource.get(String.class);
	
		return output;
	}
	
	static WebResource getWebResource() {
		Client client = Client.create();
		WebResource resource = client.resource(baseURI);

		return resource;
	}
}
