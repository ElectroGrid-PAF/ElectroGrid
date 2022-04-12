package com.electricityaccount.service;

import com.sun.jersey.api.client.Client;

/**
 * ElectricityAccountInterService class handles inter-service communication
 * between ElectricityAccountService and other services
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */


public class ElectricityAccountInterService {
	private static final String base_URI = "http://localhost:8080/";
	private Client client;
	
	public ElectricityAccountInterService() {
		super();
		client = Client.create();
	}
}
