package com.electricityaccount.model;

/**
 * ElectricityAccount is the model class for ElectricityAccount entity
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public class ElectricityAccount {
	private int eacc_id;
	private String eacc_name;
	private String billing_address;
	private String con_type;
	private String con_purpose;
	private String con_status;
	private double electrcity_supply;
	private String premise;
	
	public ElectricityAccount() {
		
	}

	public ElectricityAccount(int eacc_id, String eacc_name, String billing_address, String con_type,
			String con_purpose, String con_status, double electrcity_supply, String premise) {
		super();
		this.eacc_id = eacc_id;
		this.eacc_name = eacc_name;
		this.billing_address = billing_address;
		this.con_type = con_type;
		this.con_purpose = con_purpose;
		this.con_status = con_status;
		this.electrcity_supply = electrcity_supply;
		this.premise = premise;
	}

	public int getEacc_id() {
		return eacc_id;
	}

	public void setEacc_id(int eacc_id) {
		this.eacc_id = eacc_id;
	}

	public String getEacc_name() {
		return eacc_name;
	}

	public void setEacc_name(String eacc_name) {
		this.eacc_name = eacc_name;
	}

	public String getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}

	public String getCon_type() {
		return con_type;
	}

	public void setCon_type(String con_type) {
		this.con_type = con_type;
	}

	public String getCon_purpose() {
		return con_purpose;
	}

	public void setCon_purpose(String con_purpose) {
		this.con_purpose = con_purpose;
	}

	public String getCon_status() {
		return con_status;
	}

	public void setCon_status(String con_status) {
		this.con_status = con_status;
	}

	public double getElectrcity_supply() {
		return electrcity_supply;
	}

	public void setElectrcity_supply(double electrcity_supply) {
		this.electrcity_supply = electrcity_supply;
	}

	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	@Override
	public String toString() {
		return "ElectricityAccount [eacc_id=" + eacc_id + ", eacc_name=" + eacc_name + ", billing_address="
				+ billing_address + ", con_type=" + con_type + ", con_purpose=" + con_purpose + ", con_status="
				+ con_status + ", electrcity_supply=" + electrcity_supply + ", premise=" + premise + "]";
	}
}
