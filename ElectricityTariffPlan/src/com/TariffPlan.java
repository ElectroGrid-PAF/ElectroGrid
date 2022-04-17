package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class TariffPlan {
	private Connection con;

	public TariffPlan() {
		this.con = new DbConnection().getConnection();
	}

	public String CreateTariffPlan(String ET_ID, String Tarrif_Block, double Unit_Rate, double Fixed_Charge) {

		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into electricity_tariff_plan " + "	(ET_ID,Tarrif_Block, Unit_Rate, Fixed_Charge)"
					+ " values (?,?, ? , ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, ET_ID);
			preparedStmt.setString(2, Tarrif_Block);
			preparedStmt.setDouble(3, Unit_Rate);
			preparedStmt.setDouble(4, Fixed_Charge);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Tariff Plan created successfully";
		} catch (Exception e) {
			output = "Error while inserting the Tariff Plan.";
			e.printStackTrace();
		}
		return output;

	}

	public String DeleteTariffPlan(String ID) {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from electricity_tariff_plan where ET_ID = ? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, ID);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Tariff Plan Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the TariffPlan !!";
			e.printStackTrace();
		}
		return output;
	}

	public String UpdateTariffPlan(String eT_ID, String tariff_Block, double ur, double fc) {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE electricity_tariff_plan SET Tarrif_Block = ? , Unit_Rate = ?, Fixed_Charge = ? WHERE ET_ID =? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values

			preparedStmt.setString(1, tariff_Block);
			preparedStmt.setDouble(2, ur);
			preparedStmt.setDouble(3, fc);
			preparedStmt.setString(4, eT_ID);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the tariff plan table.";
			e.printStackTrace();
		}
		return output;
	}

	public double[] GetTariffPlan(String id) {
		double[] arr = new double[2];
		arr[0] = 0;
		arr[1] = 1;
		try {
			if (con == null) {
				return arr;
			}

			String query = "select * from electricity_tariff_plan where ET_ID = '"+id+"' ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				double Fixed_Charge = rs.getDouble("Fixed_Charge");
				double Unit_Rate = rs.getDouble("Unit_Rate");
				arr[0] = Fixed_Charge;
				arr[1] = Unit_Rate;
			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return arr;
	}

}
