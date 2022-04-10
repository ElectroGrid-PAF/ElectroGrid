package com.electricityaccount.model;

import java.sql.Connection;
import java.util.Map;

public interface IElectricityAccount {
	public Connection electricityAccountDBConnection();

	public String insertElectricityAccount(String eacc_name, String billing_address, String eacc_type, String eacc_purpose, String eacc_status, double electrcity_supply, String premise);

	public Map<String, Object> getAllElectricityAccounts();
	
	public Map<String, Object> getElectricityAccount();
	
	public String updateElectricityAccount(int eacc_id, String eacc_name, String billing_address, String eacc_type, String eacc_purpose, String eacc_status, double electrcity_supply, String premise);
	
	public String deleteElectricityAccount(int eacc_id);
	
	public Map<String, Object> getElectricityAccountByPremise(String productType);
}
