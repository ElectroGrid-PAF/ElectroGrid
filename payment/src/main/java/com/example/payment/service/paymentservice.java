package com.example.payment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.payment.model.paymentmodel;

public class paymentservice {
	Connection con;
	
	public paymentservice(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/payment?useSSL=false");
			String uname = "root";
			String pwd = "root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
		} catch(Exception e) {
			System.out.println(e+"data insert was unsuccessful");
		}
	}
	
	public paymentmodel insertPayment(paymentmodel payment) {
		String insert = "insert into payment(pid,acc,unit,price) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, payment.getPid());
			ps.setString(2, payment.getAcc());
			ps.setLong(3, payment.getUnit());
			ps.setLong(4, payment.getPrice());
			
			ps.execute();
			
			
		}catch(Exception e){
			System.out.println(e+"data insert was unsuccessful");
		}
		
		return payment;  
	}
	
public ArrayList<paymentmodel> getPayment() throws SQLException{
		
		ArrayList<paymentmodel> data = new ArrayList<paymentmodel>();
		
		String select = "select * from payment";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			paymentmodel model = new paymentmodel();
			
			model.setPid(rs.getString("pid")); // column name
			model.setAcc(rs.getString("acc"));
			model.setUnit(rs.getInt("unit"));
			model.setPrice(rs.getInt("price"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<paymentmodel> getPaymentById(int id) throws SQLException{
		
		ArrayList<paymentmodel> data = new ArrayList<paymentmodel>();
		String select = "select * from payment where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			paymentmodel model = new paymentmodel();
			
			model.setPid(rs.getString("pid")); // column name
			model.setAcc(rs.getString("acc"));
			model.setUnit(rs.getInt("unit"));
			model.setPrice(rs.getInt("price"));	
			data.add(model);		
		}		
		return data;	
	}
	
	public paymentmodel updatetPayment(paymentmodel payment) {
		String insert = "update payment set name=? , age=? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, payment.getPid());
			ps.setString(2, payment.getAcc());
			ps.setLong(3, payment.getUnit());
			ps.setLong(4, payment.getPrice());
			ps.setInt(5, payment.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return payment;
		
	}
	

	public int deletetPayment(int id) {
		String insert = "delete from payment where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
		
	}
}
