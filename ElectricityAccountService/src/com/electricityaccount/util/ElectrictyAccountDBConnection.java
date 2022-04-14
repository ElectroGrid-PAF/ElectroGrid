package com.electricityaccount.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ElectrictyAccountDBConnection class is for initiating data base connection
 * Implemented based on Singleton design pattern
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public final class ElectrictyAccountDBConnection {
	private static ElectrictyAccountDBConnection dbConnection;
	private static String jdbcURL = "jdbc:mysql://localhost:3306/ElectricityAccountDB?useSSL=false";
	private static String jdbcUsername =  "root";
	private static String jdbcPassword = "gobisql123";

	public ElectrictyAccountDBConnection() {

	}

	/**
	 * 
	 * @return connection
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		if(dbConnection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}
}
