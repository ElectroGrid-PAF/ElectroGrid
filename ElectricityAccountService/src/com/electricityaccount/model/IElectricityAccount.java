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
	public String insertElectricityAccount(String eacc_name, String billing_address, String con_type, String con_purpose, String con_status, String electrcity_supply, String premise);

	public String updateElectricityAccount(int eacc_id, String eacc_name, String billing_address, String con_type, String con_purpose, String con_status, String electrcity_supply, String premise);

	public String deleteElectricityAccount(int eacc_id);

	public Map<String, Object> getAllElectricityAccounts();

	public Map<String, Object> getElectricityAccount();

	public Map<String, Object> getElectricityAccountByPremise(String productType);
}
