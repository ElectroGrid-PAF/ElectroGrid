package com.electricityaccount.model;

/**
 * ElectricityAccount is the model class for ElectricityAccount entity
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public class ElectricityAccount {
	private int eaccID;
	private String eaccName;
	private String billingAddress;
	private String conType;
	private String conPurpose;
	private String conStatus;
	private String electrcitySupply;
	private String premise;

	public ElectricityAccount() {

	}

	public ElectricityAccount(int eaccID, String eaccName, String billingAddress, String conType, String conPurpose,
			String conStatus, String electrcitySupply, String premise) {
		super();
		this.eaccID = eaccID;
		this.eaccName = eaccName;
		this.billingAddress = billingAddress;
		this.conType = conType;
		this.conPurpose = conPurpose;
		this.conStatus = conStatus;
		this.electrcitySupply = electrcitySupply;
		this.premise = premise;
	}

	public int getEaccID() {
		return eaccID;
	}

	public void setEaccID(int eaccID) {
		this.eaccID = eaccID;
	}

	public String getEaccName() {
		return eaccName;
	}

	public void setEaccName(String eaccName) {
		this.eaccName = eaccName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

	public String getConPurpose() {
		return conPurpose;
	}

	public void setConPurpose(String conPurpose) {
		this.conPurpose = conPurpose;
	}

	public String getConStatus() {
		return conStatus;
	}

	public void setConStatus(String conStatus) {
		this.conStatus = conStatus;
	}

	public String getElectrcitySupply() {
		return electrcitySupply;
	}

	public void setElectrcitySupply(String electrcitySupply) {
		this.electrcitySupply = electrcitySupply;
	}

	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	@Override
	public String toString() {
		return "ElectricityAccount [eaccID=" + eaccID + ", eaccName=" + eaccName + ", billingAddress=" + billingAddress
				+ ", conType=" + conType + ", conPurpose=" + conPurpose + ", conStatus=" + conStatus
				+ ", electrcitySupply=" + electrcitySupply + ", premise=" + premise + "]";
	}
}
