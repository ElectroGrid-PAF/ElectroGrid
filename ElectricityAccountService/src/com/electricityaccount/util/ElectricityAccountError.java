package com.electricityaccount.util;

/**
 * ElectricityAccountError class handles errors occurred in server model
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public class ElectricityAccountError {
	private String errorMessage;
	
	public ElectricityAccountError() {

	}

	/**
	 * 
	 * @param errorMessage
	 */
	public ElectricityAccountError(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
