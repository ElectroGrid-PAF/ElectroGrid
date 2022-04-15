package com.Egrid.Ereadings;

public class Ebill {
	String Account_ID;
	String Invoice_No;
	double Bill_Amount;
	double Units_Consumed;
	String Issued_Date;

	public String getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(String account_ID) {
		Account_ID = account_ID;
	}

	public String getInvoice_No() {
		return Invoice_No;
	}

	public void setInvoice_No(String invoice_No) {
		Invoice_No = invoice_No;
	}

	public double getBill_Amount() {
		return Bill_Amount;
	}

	public void setBill_Amount(double bill_Amount) {
		Bill_Amount = bill_Amount;
	}

	public double getUnits_Consumed() {
		return Units_Consumed;
	}

	public void setUnits_Consumed(double units_Consumed) {
		Units_Consumed = units_Consumed;
	}

	public String getIssued_Date() {
		return Issued_Date;
	}

	public void setIssued_Date(String issued_Date) {
		Issued_Date = issued_Date;
	}

	public Ebill(String account_ID, String invoice_No, double bill_Amount, double units_Consumed, String issued_Date) {
		super();
		Account_ID = account_ID;
		Invoice_No = invoice_No;
		Bill_Amount = bill_Amount;
		Units_Consumed = units_Consumed;
		Issued_Date = issued_Date;
	}

	public Ebill() {
		
	}

}
