package com.electricityaccount.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.electricityaccount.model.ElectricityAccount;
import com.electricityaccount.model.ElectricityAccountLogic;
import com.electricityaccount.model.IElectricityAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * ElectricityAccountService class is the RESTful interface for ElectricityAccount resource
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

@Path("/Accounts")
public class ElectricityAccountService {

	private IElectricityAccount iElectricityAccount = new ElectricityAccountLogic();

	// Retrieve all electricity accounts
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String listAllElectricityAccounts() {
		
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();

		Gson gson = gb.create();
		return gson.toJson(iElectricityAccount.getAllElectricityAccounts());
	}
	
	// Retrieve specific electricity account
	@GET
	@Path("/{eaccID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readElectricityAccount(@PathParam("eaccID") int eaccID) {
		
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();

		Gson gson = gb.create();
		return gson.toJson(iElectricityAccount.getElectricityAccountByID(eaccID));
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createElectricityAccount(ElectricityAccount eacc) {
		
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();

		Gson gson = gb.create();
		return gson.toJson(iElectricityAccount.insertElectricityAccount(eacc));
	}
}
