package com.electricityaccount.model;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IElectricityAccount is the interface for ElectricityAccountDB logic
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public interface IElectricityAccount {
	public String insertElectricityAccount(ElectricityAccount eacc);

	public String updateElectricityAccount(ElectricityAccount ecc);
	
	public String updateElectricityAccountStatus(int eacc_id, String staus);

	public String deleteElectricityAccount(int eacc_id);

	public Map<String, Object> getAllElectricityAccounts();

	public Map<String, Object> getElectricityAccountByID(int id);

	public Map<String, Object> getElectricityAccountByPremise(String productType);
}
