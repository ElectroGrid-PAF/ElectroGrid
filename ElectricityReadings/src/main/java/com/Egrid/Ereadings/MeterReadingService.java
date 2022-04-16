package com.Egrid.Ereadings;

import java.sql.Date;
import java.text.ParseException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import javax.ws.rs.PathParam;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/MeterReadings")
public class MeterReadingService {

	MeterReadingModel readingObj = new MeterReadingModel();

	@GET
	@Path("/GetBills")
	@Produces( MediaType.APPLICATION_JSON)
	public String GetBills() {
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson = gb.create();
		
	
		return gson.toJson(readingObj.GetBills()) ;
	}

	// Reading all the records from meterreadings table
	@POST
	@Path("/Bills")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_HTML)
	public String GenBills(String XmlData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(XmlData, "", Parser.xmlParser());
		// Read the value from the element <ID> and <MID>

		String ID = doc.select("ID").text();
		String MID = doc.select("MID").text();
		String output = readingObj.GenBills(ID, MID);
		return output;
	}

	@GET
	@Path("/ViewAll")
	@Produces(MediaType.TEXT_HTML)
	public String GetMeterReadings() {
		return readingObj.GetMeterReadings();
	}

	// Reading one particular record from meterreadings table
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String getAlien(@PathParam("id") int id) {

		return readingObj.GetMeterReadings(id);
	}

	// sending meter readings of customer to database.
	@POST
	@Path("/AddReadings")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String CreateMeterReading(@FormParam("MID") String MID, @FormParam("ID") String ID,
			@FormParam("Last_Reading") double Last_Reading, @FormParam("New_Reading") double New_Reading,
			@FormParam("Reviewed_By") String Reviewed_By, @FormParam("Reviewed_Date") Date Reviewed_Date) {

		double Lr = (double) Math.round(Last_Reading * 100) / 100;
		double Nr = (double) Math.round(New_Reading * 100) / 100;

		String output = readingObj.CreateMeterReadings(MID, ID, Lr, Nr, Reviewed_By, Reviewed_Date);
		return output;

	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteMeterReading(String XmlData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(XmlData, "", Parser.xmlParser());
		// Read the value from the element <ID> and <MID>

		String ID = doc.select("ID").text();
		String MID = doc.select("MID").text();
		String output = readingObj.DeleteReading(ID, MID);
		return output;
	}

	@PUT
	@Path("/UpdateReadings")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String UpdateMeterReading(String JsonData) throws ParseException {
		// Convert the input string to a JSON object
		JsonObject meterReadingObject = new JsonParser().parse(JsonData).getAsJsonObject();
		// Read the values from the JSON object
		String ID = meterReadingObject.get("ID").getAsString();
		String MID = meterReadingObject.get("MID").getAsString();
		Double Last_Reading = meterReadingObject.get("Last_Reading").getAsDouble();
		Double New_Reading = meterReadingObject.get("New_Reading").getAsDouble();
		String Reviewed_By = meterReadingObject.get("Reviewed_By").getAsString();
		String Reviewed_Date = meterReadingObject.get("Reviewed_Date").getAsString();

		String output = readingObj.UpdateMeterReadings(ID, MID, Last_Reading, New_Reading, Reviewed_By, Reviewed_Date);
		return output;
	}

}
