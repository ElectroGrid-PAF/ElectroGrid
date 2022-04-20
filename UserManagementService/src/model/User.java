package model;
import java.sql.*;

//Registration Number: IT20037888
//Name: J.D. Ranasinghe
//Service: User Management Service

public class User {
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
	
	public String RegisterUser (String Name, String Email, String Address, String PhoneNo, String Username, String Password, String UserType) { 
		String output = ""; 
		try { 
			Connection con = connect(); 
			if (con == null) {
				return "Error while connecting to the database when registering user!"; 
			} 
			 
			// Create a prepared statement
			String query = " INSERT INTO user (`UserID`,`Name`,`Email`,`Address`,`PhoneNo`, `Username`, `Password`, `UserType`)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
				
			// Binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, Name); 
			preparedStmt.setString(3, Email); 
			preparedStmt.setString(4, Address); 
			preparedStmt.setString(5, PhoneNo); 
			preparedStmt.setString(6, Username); 
			preparedStmt.setString(7, Password); 
			preparedStmt.setString(8, UserType); 
				
			// Execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "User registered successfully!"; 
		} 
		catch (Exception e) { 
			output = "Error while registering user!"; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	 }
	
	 public String MyProfile (String Username) {
		 String output = "";
		 try {
			 Connection con = connect();
			 if (con == null) {
				 return "Error while connecting to the database when reading user profile!"; 
			 }
			 
			 String query = "SELECT * FROM user WHERE username='"+Username+"'"; 
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
		 
			 // Iterate through the rows in the result set
			 while (rs.next()) {
				 String UserID = Integer.toString(rs.getInt("UserID"));
				 String Name = rs.getString("Name");
				 String Email = rs.getString("Email");
				 String Address = rs.getString("Address");
				 String PhoneNo = rs.getString("PhoneNo");
				 String username = rs.getString("Username");
				 String Password = rs.getString("Password");
				 String UserType = rs.getString("UserType");
		 
				 output += "<p>" + "User ID: " + UserID + "</p>";
				 output += "<p>" + "Name: " + Name + "</p>";
				 output += "<p>" + "Email: " + Email + "</p>";
				 output += "<p>" + "Address: " + Address + "</p>";
				 output += "<p>" + "Phone Number: " + PhoneNo + "</p>";
				 output += "<p>" + "Username: " + username + "</p>";
				 output += "<p>" + "Password: " + Password + "</p>";
				 output += "<p>" + "User Type: " + UserType + "</p>";
			 }
		 
			 con.close();
		 }
		 catch (Exception e) {
			 output = "Error in loading user profile!";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 } 
	 
	 public String UpdateProfile (String UserID, String Name, String Email, String Address, String PhoneNo, String Username, String Password, String UserType) {
		 String output = "";
		 try {
			 Connection con = connect();
			 if (con == null) {
				 return "Error while connecting to the database when updating profile!"; 
			 }

			 String query = "UPDATE user SET Name = ?,Email = ?,Address = ?,PhoneNo = ?, Username = ?, Password = ?, UserType = ? WHERE UserID = ?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 //Binding values
			 preparedStmt.setString(1, Name);
			 preparedStmt.setString(2, Email);
			 preparedStmt.setString(3, Address);
			 preparedStmt.setString(4, PhoneNo);
			 preparedStmt.setString(5, Username);
			 preparedStmt.setString(6, Password);
			 preparedStmt.setString(7, UserType);
			 preparedStmt.setInt(8, Integer.parseInt(UserID));
			 //Execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "The profile has been successfully updated!";
		 }
		 catch (Exception e) {
			 output = "Error in updating the user profile!";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 } 
	 
	 public String DeleteAccount (String Username) {
		 String output = "";
		 try {
			 Connection con = connect();
			 if (con == null) {
				 return "Error while connecting to the database to delete account!"; 
			 }
			 
			 //Create a prepared statement
			 String query = "DELETE FROM user WHERE Username = ?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setString(1, Username);
	 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "User account removed successfully! ";
		 }
		 catch (Exception e) {
			 output = "Error in deleting the user account!";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 } 
	 
    		
}