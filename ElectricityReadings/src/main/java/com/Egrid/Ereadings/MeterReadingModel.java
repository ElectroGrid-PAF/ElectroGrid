package com.Egrid.Ereadings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;



public class MeterReadingModel {

	private Connection con;

	public MeterReadingModel() {
		this.con = new DBconnection().getConnection();
	}

	public String CreateMeterReadings(String MID, String iD, double last_Reading, double new_Reading,
			String reviewed_By, Date reviewed_Date) {

		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into meterreadings "
					+ "	(Meter_ID,Account_ID, Last_Reading, New_Reading, Reviewed_By, Reviewed_Date)"
					+ " values (?,?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, MID);
			preparedStmt.setString(2, iD);
			preparedStmt.setDouble(3, last_Reading);
			preparedStmt.setDouble(4, new_Reading);
			preparedStmt.setString(5, reviewed_By);
			preparedStmt.setDate(6, reviewed_Date);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Meter Reading inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Meter reading.";
			e.printStackTrace();
		}
		return output;
	}

	public String DeleteReading(String ID, String mID) {
		{
			String output = "";
			try {

				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from meterreadings where Account_ID = ? AND Meter_ID = ?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, ID);
				preparedStmt.setString(2, mID);

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "MeterReading Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the meter readings !!";
				e.printStackTrace();
			}
			return output;
		}
	}

	public String UpdateMeterReadings(String Id, String MID, double last_Reading, double new_Reading,
			String reviewed_By, String reviewed_Date) {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE meterreadings SET Last_Reading=?,New_Reading=?,Reviewed_By=?,Reviewed_Date=? WHERE Meter_ID =? AND Account_ID = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values

			preparedStmt.setDouble(1, last_Reading);
			preparedStmt.setDouble(2, new_Reading);
			preparedStmt.setString(3, reviewed_By);
			preparedStmt.setString(4, reviewed_Date);
			preparedStmt.setString(5, MID);
			preparedStmt.setString(6, Id);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the research.";
			e.printStackTrace();
		}
		return output;
	}

	public String GetMeterReadings() {
	//	StringBuilder  out = new StringBuilder ();
		String output = "";

		try

		{
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Account_ID</th><th>Last_Reading</th>" + "<th>New_Reading </th>"
					+ "<th>Reviewed_By</th>" + "<th>Reviewed_Date</th>" + "<th>Meter_ID</th>";

			String query = "select * from meterreadings";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String Account_ID = rs.getString("Account_ID");
				String Last_Reading = Double.toString(rs.getDouble("Last_Reading"));
				String New_Reading = Double.toString(rs.getDouble("New_Reading"));
				String Reviewed_By = rs.getString("Reviewed_By");
				String Reviewed_Date = rs.getString("Reviewed_Date");
				String Meter_ID = rs.getString("Meter_ID");
				// Add into the html table
				output += "<tr><td>" + Account_ID + "</td>";
				output += "<td>" + Last_Reading + "</td>";
				output += "<td>" + New_Reading + "</td>";
				output += "<td>" + Reviewed_By + "</td>";
				output += "<td>" + Reviewed_Date + "</td>";
				output += "<td>" + Meter_ID + "</td>";

			}

			con.close();

			// Complete the html table
			output += "</tr></table>";

		} catch (Exception e) {
			output = "Error while retreiving the meterreading table .";
			e.printStackTrace();

		}

		return output;

	}

	public String GetMeterReadings(int id) {
		String output = "";

		try

		{
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Account_ID</th><th>Last_Reading</th>" + "<th>New_Reading </th>"
					+ "<th>Reviewed_By</th>" + "<th>Reviewed_Date</th>" + "<th>Meter_ID</th>";

			String query = "select * from meterreadings where Account_ID =" + id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String Account_ID = rs.getString("Account_ID");
				String Last_Reading = Double.toString(rs.getDouble("Last_Reading"));
				String New_Reading = Double.toString(rs.getDouble("New_Reading"));
				String Reviewed_By = rs.getString("Reviewed_By");
				String Reviewed_Date = rs.getString("Reviewed_Date");
				String Meter_ID = rs.getString("Meter_ID");
				// Add into the html table
				output += "<tr><td>" + Account_ID + "</td>";
				output += "<td>" + Last_Reading + "</td>";
				output += "<td>" + New_Reading + "</td>";
				output += "<td>" + Reviewed_By + "</td>";
				output += "<td>" + Reviewed_Date + "</td>";
				output += "<td>" + Meter_ID + "</td>";

			}

			con.close();

			// Complete the html table
			output += "</tr></table>";

		} catch (Exception e) {
			output = "Error while retreiving the meterreading table .";
			e.printStackTrace();

		}

		return output;
	}

	public String GenBills(String id, String mID) {
		String output = "";

		try {
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			String query = "select * from meterreadings where Account_ID = '" + id + "' AND Meter_ID = '" + mID + "' ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String Account_ID = rs.getString("Account_ID");
				double Last_Reading = rs.getDouble("Last_Reading");
				double New_Reading = rs.getDouble("New_Reading");
				String Reviewed_Date = rs.getString("Reviewed_Date");
				String Meter_ID = rs.getString("Meter_ID");

				output = GenBills2(Account_ID,Meter_ID, Last_Reading, New_Reading, Reviewed_Date);

			}
			con.close();
		} catch (Exception e) {

			e.printStackTrace();

		}

		return output;
	}

	public String GenBills2(String Id, String MID, double last_Reading, double new_Reading, String reviewed_Date) {

		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into electricity_bills "
					+ "	(Account_ID,Invoice_No, Bill_Amount, Units_Consumed, Issued_Date)"
					+ " values (?,?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values

			String Invoice_No = "INV" + reviewed_Date + "B" + Id + MID;
			double Units_Consumed = new_Reading - last_Reading;
			double UC = (double) Math.round(Units_Consumed * 100) / 100;
			BillGenerateClient BillObj = new BillGenerateClient();
			double Fc = 0;
			double URate  = 0 ;
			double Bill_Amount = 0;
			

			String OBJECT = "";
			//IF-ELSE Condition Used to get Correct Values from Tariff Plan Service
			if (Units_Consumed <= 100) {
				//Passing parameter is ET_ID Of Tariffplan Service 
				 OBJECT = BillObj.read(1);
		
			}
			else if (Units_Consumed > 100 && Units_Consumed <= 200){
				 OBJECT = BillObj.read(2);
			}
			
             else if (Units_Consumed > 200 && Units_Consumed <= 300){
            	  OBJECT = BillObj.read(3);
			}
			
			 else if (Units_Consumed > 300 && Units_Consumed <= 400){
				  OBJECT = BillObj.read(4);
			}
			
		    else if (  Units_Consumed >= 500 ){
		    	 OBJECT = BillObj.read(5);
			}
			
			
			String[] arrOfStr = OBJECT.split(",", 2);
			Fc = Double.parseDouble(arrOfStr[0]);
			URate = Double.parseDouble(arrOfStr[1]);

			Bill_Amount = Fc + (URate * UC);
			
			preparedStmt.setString(1, Id);
			preparedStmt.setString(2, Invoice_No );
			preparedStmt.setDouble(3, Bill_Amount);
			preparedStmt.setDouble(4, Units_Consumed);
			preparedStmt.setString(5, reviewed_Date);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "BILL ADDED";
		} catch (Exception e) {
			output = "Error while inserting the E bILLs";
			e.printStackTrace();
		}
		return output;

	}


		
		public List<Ebill> GetBills() {
			List<Ebill> Ebills = new ArrayList<>();
			String sql = "select * from electricity_bills";

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Ebill a = new Ebill();
					a.setAccount_ID(rs.getString("Account_ID"));
					a.setBill_Amount(rs.getDouble("Bill_Amount"));
					a.setInvoice_No(rs.getString("Invoice_No"));
					a.setIssued_Date(rs.getString("Issued_Date"));
					a.setUnits_Consumed(rs.getDouble("Units_Consumed"));
					Ebills.add(a);
				}

			} catch (SQLException e) {

				e.printStackTrace();
			
			}

			return Ebills;

		}

}