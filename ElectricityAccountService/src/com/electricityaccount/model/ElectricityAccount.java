package com.electricityaccount.model;

public class ElectricityAccount {
	private int eacc_id;
	private String eacc_name;
	private String billing_address;
	private String eacc_type;
	private String eacc_purpose;
	private String eacc_status;
	private double electrcity_supply;
	private String premise;
	
	public ElectricityAccount() {
		
	}

	public ElectricityAccount(int eacc_id, String eacc_name, String billing_address, String eacc_type,
			String eacc_purpose, String eacc_status, double electrcity_supply, String premise) {
		super();
		this.eacc_id = eacc_id;
		this.eacc_name = eacc_name;
		this.billing_address = billing_address;
		this.eacc_type = eacc_type;
		this.eacc_purpose = eacc_purpose;
		this.eacc_status = eacc_status;
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

	public String getEacc_type() {
		return eacc_type;
	}

	public void setEacc_type(String eacc_type) {
		this.eacc_type = eacc_type;
	}

	public String getEacc_purpose() {
		return eacc_purpose;
	}

	public void setEacc_purpose(String eacc_purpose) {
		this.eacc_purpose = eacc_purpose;
	}

	public String getEacc_status() {
		return eacc_status;
	}

	public void setEacc_status(String eacc_status) {
		this.eacc_status = eacc_status;
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
				+ billing_address + ", eacc_type=" + eacc_type + ", eacc_purpose=" + eacc_purpose + ", eacc_status="
				+ eacc_status + ", electrcity_supply=" + electrcity_supply + ", premise=" + premise + "]";
	}
}
