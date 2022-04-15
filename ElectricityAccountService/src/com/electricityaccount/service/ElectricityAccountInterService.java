package com.electricityaccount.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * ElectricityAccountInterService class handles inter-service communication
 * between ElectricityAccountService and other services
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public class ElectricityAccountInterService {

	private static final String baseURI = "http://localhost:8080/Ereadings/webapi/MeterReadings/GetBills";
	private Client client;
	ObjectMapper mapper;

	public ElectricityAccountInterService() {
		super();
		client = Client.create();
		mapper = new ObjectMapper();
	}

	// get all the bills for electricity accounts from Electricity Reading Service
	public JSONArray getAllBills() {
		
		WebResource webResource = client.resource(baseURI);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		JSONArray jsonArr = new JSONArray(response.getEntity(String.class));
		
		return jsonArr;	
	}
}
