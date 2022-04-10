package com.electricityaccount.model;

import java.sql.Connection;
import java.util.Map;

/**
 * IElectricityAccount is the interface for ElectricityAccountDB logic
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public interface IElectricityAccount {
	public Connection electricityAccountDBConnection();

	public String insertElectricityAccount(String eacc_name, String billing_address, String eacc_type, String eacc_purpose, String eacc_status, double electrcity_supply, String premise);

	public Map<String, Object> getAllElectricityAccounts();
	
	public Map<String, Object> getElectricityAccount();
	
	public String updateElectricityAccount(int eacc_id, String eacc_name, String billing_address, String eacc_type, String eacc_purpose, String eacc_status, double electrcity_supply, String premise);
	
	public String deleteElectricityAccount(int eacc_id);
	
	public Map<String, Object> getElectricityAccountByPremise(String productType);
}
