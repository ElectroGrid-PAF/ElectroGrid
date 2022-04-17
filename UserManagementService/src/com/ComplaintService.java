package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Complaint;

@Path("/Complaint/secured") 

public class ComplaintService {
	 Complaint complaint = new Complaint();
	 
	 @POST
	 @Path("/makeComplaint/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String MakeComplaint (
		  @FormParam("SenderName") String SenderName,
		  @FormParam("RecipientDept") String RecipientDept,
		  @FormParam("EmailAddress") String EmailAddress,
		  @FormParam("Subject") String Subject,
		  @FormParam("Complaint") String Complaint,
		  @FormParam("Response") String Response
		  ) {
			  String output = complaint.MakeComplaint(SenderName, RecipientDept, EmailAddress, Subject, Complaint, Response);
			  return output;
	 }
	 
	 @GET
	 @Path("/viewComplaints/") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String ViewAllComplaints() { 
		 return complaint.ViewAllComplaints(); 
	 }

	 @PUT
	 @Path("/addResponse/") 
	 @Consumes(MediaType.APPLICATION_JSON) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String updateItem(String responseData) { 
		 JsonObject responseObject = new JsonParser().parse(responseData).getAsJsonObject(); 
		 String ComplaintID = responseObject.get("ComplaintID").getAsString(); 
		 String Response = responseObject.get("Response").getAsString(); 
		 String output = complaint.AddResponse(ComplaintID, Response); 
		 return output; 
	 }
	 
	 @DELETE
		@Path("/deleteComplaint/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN) 
		public String RemoveComplaint (String complaintData) { 
			
			//Convert the input string to an XML document
			Document complaintDoc = Jsoup.parse(complaintData, "", Parser.xmlParser()); 
		 
			//Read the value from the element <itemID>
			String ComplaintID = complaintDoc.select("ComplaintID").text(); 
			String output = complaint.RemoveComplaint(ComplaintID); 
			return output; 
		}
}
