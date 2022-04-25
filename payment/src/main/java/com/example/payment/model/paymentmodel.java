package com.example.payment.model;

public class paymentmodel {
	private int id;
	private String pid;
	private String acc;
	private int unit;
	private int price;
	
	public paymentmodel() {}
	
	public paymentmodel(String pid, String acc, int unit, int price) {
		super();
		this.id = id;
		this.pid = pid;
		this.acc = acc;
		this.unit = unit;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
