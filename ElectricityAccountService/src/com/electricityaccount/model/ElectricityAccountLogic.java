package com.electricityaccount.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ErrorManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.electricityaccount.util.ElectricityAccountError;
import com.electricityaccount.util.ElectrictyAccountDBConnection;

/**
 * ElectricityAccountLogic handles business logic on ElectricityAccount entity
 * 
 * @author 	Gobisan, PAF_Y3.S1.WE.DS.04_113
 * @version 1.0 Apr 2022
 */

public class ElectricityAccountLogic implements IElectricityAccount{

	// Initialize DB Connection
	private ElectrictyAccountDBConnection dbconnection = new ElectrictyAccountDBConnection();

	// Initialize Logger
	public static final Logger log = Logger.getLogger(ElectricityAccountLogic.class.getName());

	// Declare Error Message
	private static final String DB_CONNECTION_ERROR_MSG = "Error while connecting to the database";
	private static final String DB_CONNECTION_ERROR_LBL = "DB Connection Error";

	// Query
	private static final String INSERT_ELECTRICITY_ACCOUNT = "INSERT INTO ElectricityAccount "
			+ "(eacc_name, billing_address, con_type, con_purpose, con_status, electrcity_supply, premise)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_ALL_ELECTRICITY_ACCOUNTS = "SELECT * FROM ElectricityAccount;";

	private static final String SELECT_ELECTRICITY_ACCOUNT_BY_PREMISE = "SELECT * FROM ElectricityAccount WHERE premise = ?;";

	private static final String SELECT_ELECTRICITY_ACCOUNT_BY_ID = "SELECT * FROM ElectricityAccount WHERE eacc_id = ?;";

	private static final String UPDATE_ELECTRICITY_ACCOUNT = "UPDATE ElectricityAccount "
			+ "SET eacc_name = ?, billing_address = ?, con_type = ?, con_purpose = ?, con_status = ?, electrcity_supply = ?, premise = ?"
			+ "WHERE eacc_id = ?;";

	private static final String DELETE_ELECTRICITY_ACCOUNT = "DELETE FROM ElectricityAccount WHERE eacc_id = ?;";


	// JDBC
	private static Connection connection = null;
	private static PreparedStatement preparedStmt = null;
	private static Statement statement = null;
	private static ResultSet rs = null;

	@Override
	public String insertElectricityAccount(ElectricityAccount eacc) {
		String output = "";

		try {
			connection = dbconnection.getConnection();

			if (connection == null) {
				return DB_CONNECTION_ERROR_MSG;
			}

			// initialize prepared statement
			preparedStmt = connection.prepareStatement(INSERT_ELECTRICITY_ACCOUNT);

			// bind values
			preparedStmt.setString(1, eacc.getEaccName());
			preparedStmt.setString(2, eacc.getBillingAddress());
			preparedStmt.setString(3, eacc.getConType());
			preparedStmt.setString(4, eacc.getConPurpose());
			preparedStmt.setString(5, eacc.getConStatus());
			preparedStmt.setString(6, eacc.getElectrcitySupply());
			preparedStmt.setString(7, eacc.getPremise());

			// execute the prepared statement
			int newID = preparedStmt.executeUpdate();
			output = "Inserted successfully. New Record ID: " + newID;

		} catch (Exception e) {
			output = "Error while inserting";
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			// Close prepared statement and database connectivity
			try {
				if (preparedStmt != null) {
					preparedStmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return output;
	}

	@Override
	public String updateElectricityAccount(ElectricityAccount eacc) {
		String output = "";

		Map<String, Object> result = getElectricityAccountByID(eacc.getEaccID());

		if (result.get("ElectricityAcccount") == null) {
			return "Invalid Electricity Account ID, Update Failed";
		}

		connection = dbconnection.getConnection();

		if (connection == null) {
			return DB_CONNECTION_ERROR_MSG;
		}

		try {

			// create a prepared statement
			preparedStmt = connection.prepareStatement(UPDATE_ELECTRICITY_ACCOUNT);

			// bind values
			preparedStmt.setString(1, eacc.getEaccName());
			preparedStmt.setString(2, eacc.getBillingAddress());
			preparedStmt.setString(3, eacc.getConType());
			preparedStmt.setString(4, eacc.getConPurpose());
			preparedStmt.setString(5, eacc.getConStatus());
			preparedStmt.setString(6, eacc.getElectrcitySupply());
			preparedStmt.setString(7, eacc.getPremise());
			preparedStmt.setInt(8, eacc.getEaccID());

			preparedStmt.executeUpdate();

			output = "Updated successfully";
		} catch (SQLException e) {
			output = "Error while updating";
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			// Close prepared statement and database connectivity
			try {
				if (preparedStmt != null) {
					preparedStmt.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return output;
	}

	@Override
	public String deleteElectricityAccount(int eaccID) {
		String output = "";

		Map<String, Object> result = getElectricityAccountByID(eaccID);

		if (result.get("ElectricityAcccount") == null) {
			return "Invalid Electricity Account ID, Deletion Failed.";
		}

		try {
			connection = dbconnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deletion.";
			}

			// Initialize prepares statement
			preparedStmt = connection.prepareStatement(DELETE_ELECTRICITY_ACCOUNT);
			preparedStmt.setInt(1, eaccID);
			preparedStmt.executeUpdate();

			output = "Sueccessfully Deleted.";

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			output = "Error while deleting the electricity account.";
		} finally {

			// Close prepared statement and database connectivity at the end of transaction 
			try {
				if (preparedStmt != null) {
					preparedStmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return output;
	}

	@Override
	public Map<String, Object> getAllElectricityAccounts() {

		// Initialize Electricity account List
		List<ElectricityAccount> electricityAccountList = new ArrayList<>();

		// Initialize Error Message
		ElectricityAccountError err = new ElectricityAccountError();

		// Initialize Data to send
		Map<String, Object> data = new HashMap<>();

		try {
			connection = dbconnection.getConnection();
			if (connection == null) {
				err.setErrorMessage(DB_CONNECTION_ERROR_MSG);

				// Return connection error
				data.put(DB_CONNECTION_ERROR_LBL, err);
				return data;
			}

			// initialize a statement
			statement = connection.createStatement();


			rs = statement.executeQuery(SELECT_ALL_ELECTRICITY_ACCOUNTS);

			while (rs.next()) {
				ElectricityAccount electricityAccount = new ElectricityAccount();

				electricityAccount.setEaccID(rs.getInt("eacc_id"));
				electricityAccount.setEaccName(rs.getString("eacc_name"));
				electricityAccount.setBillingAddress(rs.getString("billing_address"));
				electricityAccount.setConType(rs.getString("con_type"));
				electricityAccount.setConPurpose(rs.getString("con_purpose"));
				electricityAccount.setConStatus(rs.getString("con_status"));
				electricityAccount.setElectrcitySupply(rs.getString("electrcity_supply"));
				electricityAccount.setPremise(rs.getString("premise"));

				electricityAccountList.add(electricityAccount);
			}

			// return electricity account list

			data.put("ElectricityAccount", electricityAccountList);
			return data;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());

			// return database read error
			data.put("DB Read Error", e.getMessage());
			return data;

		} finally {
			// Close statement and database connection
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public Map<String, Object> getElectricityAccountByID(int id) {
		// Initialize Electricity account List
		List<ElectricityAccount> electricityAccountList = new ArrayList<>();
				
		// Create Error Message
		ElectricityAccountError emsg = new ElectricityAccountError();

		// Initialize Data to return
		Map<String, Object> data = new HashMap<>();

		try {
			connection = dbconnection.getConnection();

			if (connection == null) {
				emsg.setErrorMessage(DB_CONNECTION_ERROR_MSG);
				data.put(DB_CONNECTION_ERROR_LBL, emsg);
				return data;
			}

			preparedStmt = connection.prepareStatement(SELECT_ELECTRICITY_ACCOUNT_BY_ID);
			preparedStmt.setInt(1, id);
			rs = preparedStmt.executeQuery();

			// iterate through the rows in the result set
			while (rs.next()) {
				ElectricityAccount electricityAccount = new ElectricityAccount();

				electricityAccount.setEaccID(rs.getInt("eacc_id"));
				electricityAccount.setEaccName(rs.getString("eacc_name"));
				electricityAccount.setBillingAddress(rs.getString("billing_address"));
				electricityAccount.setConType(rs.getString("con_type"));
				electricityAccount.setConPurpose(rs.getString("con_purpose"));
				electricityAccount.setConStatus(rs.getString("con_status"));
				electricityAccount.setElectrcitySupply(rs.getString("electrcity_supply"));
				electricityAccount.setPremise(rs.getString("premise"));

				electricityAccountList.add(electricityAccount);
			}

			// return electricity account list

			data.put("ElectricityAccount", electricityAccountList);
			return data;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());

			emsg.setErrorMessage(e.getMessage());
			data.put("DBReadError", emsg);

			return data;
		} finally {

			// Close statement and database connection
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public Map<String, Object> getElectricityAccountByPremise(String pid) {
		// Create Error Message
		ElectricityAccountError emsg = new ElectricityAccountError();

		// Initialize Data to return
		Map<String, Object> data = new HashMap<>();

		try {
			connection = dbconnection.getConnection();

			if (connection == null) {
				emsg.setErrorMessage(DB_CONNECTION_ERROR_MSG);
				data.put(DB_CONNECTION_ERROR_LBL, emsg);
				return data;
			}

			preparedStmt = connection.prepareStatement(SELECT_ELECTRICITY_ACCOUNT_BY_PREMISE);
			preparedStmt.setString(1, pid);
			rs = preparedStmt.executeQuery();

			// iterate through the rows in the result set
			while(rs.next()) {

				ElectricityAccount electricityAccount = new ElectricityAccount();

				electricityAccount.setEaccID(rs.getInt("eacc_id"));
				electricityAccount.setEaccName(rs.getString("eacc_name"));
				electricityAccount.setBillingAddress(rs.getString("billing_address"));
				electricityAccount.setConType(rs.getString("con_type"));
				electricityAccount.setConPurpose(rs.getString("con_purpose"));
				electricityAccount.setConStatus(rs.getString("con_status"));
				electricityAccount.setElectrcitySupply(rs.getString("electrcity_supply"));
				electricityAccount.setPremise(rs.getString("premise"));

				data.put("ElectricityAcccount", electricityAccount);
			}
			
			return data;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());

			emsg.setErrorMessage(e.getMessage());
			data.put("DBReadError", emsg);

			return data;
		} finally {

			// Close statement and database connection
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

}
