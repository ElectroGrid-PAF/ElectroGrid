package com;
import model.OutageNotice;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/OutageNotice")
public class OutageNoticeService
{
	OutageNotice noticeObj = new OutageNotice();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readNotices()
	{
	 return noticeObj.readNotices();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertNotice(@FormParam("regionID") String regionID,
	 @FormParam("group") String group,
	 @FormParam("Description") String Description,
	 @FormParam("outageStartTime") String outageStartTime,
	 @FormParam("outageEndTime") String outageEndTime,
     @FormParam("informerID") String informerID)
	{
	 String output = noticeObj.insertNotice(regionID, group, Description, outageStartTime, outageEndTime, informerID);
	 return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateNotice(String noticeData)
	{
		//Convert the input string to a JSON object
		JsonObject noticeObject = new JsonParser().parse(noticeData).getAsJsonObject();
		//Read the values from the JSON object
		String noticeID = noticeObject.get("noticeID").getAsString();
		String regionID = noticeObject.get("regionID").getAsString();
		String group = noticeObject.get("group").getAsString();
		String Description = noticeObject.get("Description").getAsString();
		String outageStartTime = noticeObject.get("outageStartTime").getAsString();
		String outageEndTime = noticeObject.get("outageEndTime").getAsString();
		String informerID = noticeObject.get("informerID").getAsString();
		
		String output = noticeObj.updateNotice(noticeID, regionID, group, Description, outageStartTime, outageEndTime, informerID);
		return output;
	}
}	
