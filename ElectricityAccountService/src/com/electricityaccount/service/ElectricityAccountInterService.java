package com.electricityaccount.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import com.electricityaccount.model.ElectricityAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.xml.bind.api.TypeReference;

/**
 * ElectricityAccountInterService class handles inter-service communication
 * between ElectricityAccountService and other services
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public class ElectricityAccountInterService {

	private static final String base_URI = "http://localhost:8080/Ereadings/webapi/MeterReadings/GetBills";
	private Client client;
	ObjectMapper mapper;

	public ElectricityAccountInterService() {
		super();
		client = Client.create();
		mapper = new ObjectMapper();
	}

	// get all the bills for electricity accounts from Electricity Reading Service
	public JSONArray getAllBills() {
		
		WebResource webResource = client.resource(base_URI);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		JSONArray jsonArr = new JSONArray(response.getEntity(String.class));
		
		return jsonArr;	
	}
}
