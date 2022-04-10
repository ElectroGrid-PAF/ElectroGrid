package com.electricityaccount.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import com.electricityaccount.util.ElectrictyAccountDBConnection;

public class ElectricityAccountLogic implements IElectricityAccount{
	// DB Connection
	private ElectrictyAccountDBConnection dbconnection = new ElectrictyAccountDBConnection();
	
	
	// Query
	private static final String INSERT_ELECTRICITY_ACCOUNT = "INSERT INTO ElectricityAccount "
			+ "(eacc_name, billing_address, con_type, con_purpose, con_status, electrcity_supply, premise)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";


	@Override
	public String insertElectricityAccount(String eacc_name, String billing_address, String con_type,
			String con_purpose, String con_status, String electrcity_supply, String premise) {
		
		String output = "";
		
		try {
			Connection con = dbconnection.getConnection();
			
			if(con==null) {
				return "Error while connecting to the database";
			}
			
			// create a prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(INSERT_ELECTRICITY_ACCOUNT);
			
			// binding values
			preparedStmt.setString(1, eacc_name);
			preparedStmt.setString(2, billing_address);
			preparedStmt.setString(3, con_type);
			preparedStmt.setString(4, con_purpose);
			preparedStmt.setString(5, con_status);
			preparedStmt.setString(6, electrcity_supply);
			preparedStmt.setString(7, premise);
			
			// execute statement
			preparedStmt.execute();
			con.close();
			output = "New record inserted successfully"; 
			
		} catch (Exception e) {
			output = "Error while inserting new record"; 
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}


	@Override
	public String updateElectricityAccount(int eacc_id, String eacc_name, String billing_address, String con_type,
			String con_purpose, String con_status, String electrcity_supply, String premise) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteElectricityAccount(int eacc_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> getAllElectricityAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> getElectricityAccount() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> getElectricityAccountByPremise(String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
