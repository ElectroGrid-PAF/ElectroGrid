package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OutageNotice {

	public Connection connect()
	{
		Connection con = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/noticesmanagement", "root", "");
			
			//For testing
			System.out.print("Successfully connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	 return con;
	}
	
	public String insertNotice(String regionID, String group, String Description, String outageStartTime, String outageEndTime, String informerID)
	{
		
		String output = "";
		
		try 
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database";
			}
		
			// create a prepared statement
			String query = " insert into notices (`noticeID`,`regionID`,`group`,`Description`,`outageStartTime`, `outageEndTime`, `informerID`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, regionID);
			preparedStmt.setString(3, group);
			preparedStmt.setString(4, Description);
			preparedStmt.setString(5, outageStartTime);
			preparedStmt.setString(6, outageEndTime);
			preparedStmt.setString(7, informerID);
		
			//execute the statement
			preparedStmt.execute();
			con.close();
		
			output = "Inserted successfully";
			
		}
		catch (Exception e)
		{
			output = "Error while inserting";
			System.err.println(e.getMessage()); 
		}
		
		return output;
	}
	
	public String readNotices()
	{
		String output = "";
		
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border='1'>"
					+ "<th>Region ID</th><th>Group</th>"
					+ "<th>Notice Description</th><th>Outage starts at</th><th>Outage ends at</th><th>Informer ID</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from notices";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next())
			{
				String noticeID = Integer.toString(rs.getInt("noticeID"));
				String regionID = rs.getString("regionID");
				String group = rs.getString("group");
				String Description = rs.getString("Description");
				String outageStartTime = rs.getString("outageStartTime");
				String outageEndTime = rs.getString("outageEndTime");
				String informerID = rs.getString("informerID");
				
				// Add a row into the html table
				output += "<tr><td>" + regionID + "</td>";
				output += "<td>" + group + "</td>";
				output += "<td>" + Description + "</td>";
				output += "<td>" + outageStartTime + "</td>";
				output += "<td>" + outageEndTime + "</td>";
				output += "<td>" + informerID + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='noticeID' type='hidden' value='" + noticeID + "'>"
						+ "</form></td></tr>";
			}
			
			con.close();
			
			 // Complete the html table
			 output += "</table>";

		}
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	public String readNoticesInRegion(String noticeID) {
		String output = "";
			
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
				
			// Prepare the html table to be displayed
			output = "<table border='1'>"
					+ "<th>Region ID</th><th>Group</th>"
					+ "<th>Notice Description</th><th>Outage starts at</th><th>Outage ends at</th><th>Informer ID</th><th>Update</th><th>Remove</th></tr>";
				
			String query = "select * from notices where regionID =?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, noticeID);
			ResultSet rs = preparedStmt.executeQuery();
				
			// iterate through the rows in the result set
			while (rs.next())
			{
				String noticeID1 = Integer.toString(rs.getInt("noticeID"));
				String regionID = rs.getString("regionID");
				String group = rs.getString("group");
				String Description = rs.getString("Description");
				String outageStartTime = rs.getString("outageStartTime");
				String outageEndTime = rs.getString("outageEndTime");
				String informerID = rs.getString("informerID");
					
				// Add a row into the html table
				output += "<tr><td>" + regionID + "</td>";
				output += "<td>" + group + "</td>";
				output += "<td>" + Description + "</td>";
				output += "<td>" + outageStartTime + "</td>";
				output += "<td>" + outageEndTime + "</td>";
				output += "<td>" + informerID + "</td>";
					
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='noticeID' type='hidden' value='" + noticeID1 + "'>"
						+ "</form></td></tr>";
			}
				
			con.close();
				
				// Complete the html table
				output += "</table>";

		}
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	public String updateNotice(String noticeID, String regionID, String group, String Description, String outageStartTime, String outageEndTime, String informerID)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 
			 // create a prepared statement
			 String query = "UPDATE notices SET regionID=?,`group`=?,Description=?,outageStartTime=?,outageEndTime=?,informerID=? WHERE noticeID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setString(1, regionID);
			 preparedStmt.setString(2, group);
			 preparedStmt.setString(3, Description);
			 preparedStmt.setString(4, outageStartTime);
			 preparedStmt.setString(5, outageEndTime);
			 preparedStmt.setString(6, informerID);
			 preparedStmt.setInt(7, Integer.parseInt(noticeID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
		 	}
		 	catch (Exception e)
		 	{
		 		output = "Error while updating the notice.";
		 		System.err.println(e.getMessage());
		 	}
		 return output; 
	}
	
	public String deleteNotice(String noticeID)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			// create a prepared statement
			String query = "delete from notices where noticeID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(noticeID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		}
		catch (Exception e)
		{
			output = "Error while deleting the notice.";
			System.err.println(e.getMessage());
		}
		
	return output;
	}
	
}

