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
	
	@GET
	@Path("/{regionID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String readNoticesInRegion(@PathParam("regionID") String regionID)
	{
		return noticeObj.readNoticesInRegion(regionID); 
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
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteNotice(String noticeData)
	{
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(noticeData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		String noticeID = doc.select("noticeID").text();
		String output = noticeObj.deleteNotice(noticeID);
		return output;
	}

}
