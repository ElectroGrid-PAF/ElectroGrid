package com;
import model.User;

//Registration Number: IT20037888
//Name: J.D. Ranasinghe
//Service: User Management Service

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Users")
public class UserService {
	User user = new User();
	
	@POST
	@Path("/register/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String UserRegistration (
		@FormParam("Name") String Name,
		@FormParam("Email") String Email,
		@FormParam("Address") String Address,
		@FormParam("PhoneNo") String PhoneNo,
		@FormParam("Username") String Username,
		@FormParam("Password") String Password,
		@FormParam("UserType") String UserType
	) {
		String output = user.RegisterUser(Name, Email, Address, PhoneNo, Username, Password, UserType);
		return output;
	}
	
	@GET
	@Path("/secured/profile/{Username}")
	@Produces(MediaType.TEXT_HTML)
	public String MyProfile (@PathParam("Username") String Username) {
		return user.MyProfile(Username);
	}
	
	@PUT
	@Path("/secured/editProfile/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String EditProfile (String userData) { 
		
		//Convert the input string to a JSON object 
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
	
		//Read the values from the JSON object
		String UserID = userObject.get("UserID").getAsString(); 
		String Name = userObject.get("Name").getAsString(); 
		String Email = userObject.get("Email").getAsString(); 
		String Address = userObject.get("Address").getAsString(); 
		String PhoneNo = userObject.get("PhoneNo").getAsString(); 
		String Username = userObject.get("Username").getAsString(); 
		String Password = userObject.get("Password").getAsString(); 
		String UserType = userObject.get("UserType"). getAsString(); 
		
		String output = user.UpdateProfile(UserID, Name, Email, Address, PhoneNo, Username, Password, UserType); 
		return output; 
	}
	
	@DELETE
	@Path("/secured/deleteProfile/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN) 
	public String DeleteProfile (String UserData) { 
		
		//Convert the input string to an XML document
		Document userDoc = Jsoup.parse(UserData, "", Parser.xmlParser()); 
	 
		//Read the value from the element <itemID>
		String UserID = userDoc.select("UserID").text(); 
		String output = user.DeleteAccount(UserID); 
		return output; 
	}
	
}
