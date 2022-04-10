package com.electricityaccount.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ElectrictyAccountDBConnection {
	private String jdbcURL = "jdbc:mysql://localhost:3306/ElectricityAccountDB?useSSL=false";
	private String jdbcUsername =  "root";
	private String jdbcPassword = "gobisql123";

	// get database connection
	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
