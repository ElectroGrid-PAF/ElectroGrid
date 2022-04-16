package model;
import java.sql.*;

//Registration Number: IT20037888
//Name: J.D. Ranasinghe
//Service: User Management Service

public class Complaint {
	private Connection connect() { 
		Connection con = null; 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usermanagementservice", "root", ""); 
			//For testing
			System.out.print("Successfully connected to the database!"); 
		} 
		catch (Exception e) {
			System.out.print("Failed to connect to the databse!"); 
			e.printStackTrace();
		} 
		return con; 
	 }
	
	public String MakeComplaint (String SenderName, String RecipientDept, String EmailAddress, String Subject, String Complaint, String Response) { 
		String output = ""; 
		String response = "";
		try { 
			Connection con = connect(); 
			if (con == null) {
				return "Error while connecting to the database when making complaints!"; 
			} 
			 
			// Create a prepared statement
			String query = " INSERT INTO complaint (`ComplaintID`,`SenderName`,`RecipientDept`,`EmailAddress`,`Subject`, `Complaint`, `Response`)" + " VALUES (?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
				
			// Binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, SenderName); 
			preparedStmt.setString(3, RecipientDept); 
			preparedStmt.setString(4, EmailAddress); 
			preparedStmt.setString(5, Subject); 
			preparedStmt.setString(6, Complaint); 
			preparedStmt.setString(7, response); 
				
			// Execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "Complaint made successfully!"; 
		} 
		catch (Exception e) { 
			output = "Error while making complaint!"; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	 }
	
	 //Read all complaints --> Update word doc function it says update complaint
	 public String ViewAllComplaints() { 
		 String output = ""; 
		 try { 
			 Connection con = connect(); 
			 if (con == null) {
				 return "Error while connecting to the database for viewing complaints!"; 
			 } 
			 output = "<table border='1'><tr>"
			 		+ "<th>Sender Name</th>"
			 		+ "<th> Recipient Department</th>" 
			 		+ "<th>Email Address</th>" 
			 		+ "<th>Subject</th>"
			 		+ "<th>Complaint</th>"
			 		+ "<th>Response</th></tr>"; 
	 
			 String query = "SELECT * FROM complaint"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
	 
			 while (rs.next()) { 
				 String ComplaintID = Integer.toString(rs.getInt("ComplaintID")); 
				 String SenderName = rs.getString("SenderName"); 
				 String RecipientDept = rs.getString("RecipientDept"); 
				 String EmailAddress = rs.getString("EmailAddress"); 
				 String Subject = rs.getString("Subject"); 
				 String Complaint = rs.getString("Complaint"); 
				 String Response = rs.getString("Response"); 
				 
				 output += "<tr><td>" + SenderName + "</td>"; 
				 output += "<td>" + RecipientDept + "</td>"; 
				 output += "<td>" + EmailAddress + "</td>"; 
				 output += "<td>" + Subject + "</td>"; 
				 output += "<td>" + Complaint + "</td>"; 
				 output += "<td>" + Response + "</td></tr>"; 
			 } 
			 
			 con.close(); 
			 output += "</table>"; 
		 } 
		 catch (Exception e) { 
			 output = "Error while viewing complaints!"; 
			 System.err.println(e.getMessage()); 
		 } 
		 return output; 
	 } 
	
	 //Respond to complaints
	 public String AddResponse (String ComplaintID, String Response) {
		 String output = "";
		 try {
			 Connection con = connect();
			 if (con == null) {
				 return "Error while connecting to the database when responding to complaints!"; 
			 }

			 String query = "UPDATE complaint SET Response = ? WHERE ComplaintID = ?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 //Binding values
			 preparedStmt.setString(1, Response);
			 preparedStmt.setInt(2, Integer.parseInt(ComplaintID));
			 //Execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "The response has been added successfully!";
		 }
		 catch (Exception e) {
			 output = "Error in responding to the complaint!";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 } 
	 
	 public String RemoveComplaint (String ComplaintID) {
		 String output = "";
		 try {
			 Connection con = connect();
			 if (con == null) {
				 return "Error while connecting to the database to remove complaint!"; 
			 }
			 
			 //Create a prepared statement
			 String query = "DELETE FROM complaint WHERE ComplaintID = ?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(ComplaintID));
	 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Complaint removed successfully! ";
		 }
		 catch (Exception e) {
			 output = "Error in removing the complaint";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 } 
	
}
