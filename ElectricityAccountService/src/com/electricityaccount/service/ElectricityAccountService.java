package com.electricityaccount.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.electricityaccount.model.ElectricityAccount;
import com.electricityaccount.model.ElectricityAccountLogic;
import com.electricityaccount.model.IElectricityAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

	// Retrieve specific electricity account by ID
	@GET
	@Path("/{eaccID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readElectricityAccount(@PathParam("eaccID") int eaccID) {

		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();

		Gson gson = gb.create();
		return gson.toJson(iElectricityAccount.getElectricityAccountByID(eaccID));
	}

	// Retrieve electricity accounts with specific premise
	@GET
	@Path("premise/{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readElectricityAccountByPremise(@PathParam("pid") String pid) {

		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();

		Gson gson = gb.create();
		return gson.toJson(iElectricityAccount.getElectricityAccountByPremise(pid));
	}

	// Insert electricity account
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

	// Update electricity account details
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateElecricityAccount(ElectricityAccount eacc) {
		return iElectricityAccount.updateElectricityAccount(eacc);
	}

	// update electricity account status
	@PUT
	@Path("/status")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateElecricityAccountStatus(String data) {

		// Convert input string to a JSON object
		JsonObject josnObj = new JsonParser().parse(data).getAsJsonObject(); 

		//Read value from the element eaccID
		String id = josnObj.get("eaccID").toString(); 
		String status = josnObj.get("conStatus").toString();

		return iElectricityAccount.updateElectricityAccountStatus(Integer.parseInt(id), status);
	}

	// Delete electricity account
	@DELETE
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteElectricityAccount(String eaccID) {

		// Convert input string to a JSON object
		JsonObject josnObj = new JsonParser().parse(eaccID).getAsJsonObject(); 

		//Read value from the element eaccID
		int id = Integer.parseInt(josnObj.get("eaccID").toString());
		
		return iElectricityAccount.deleteElectricityAccount(id);
	}
}
