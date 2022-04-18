package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

@Path("/Plans")
public class TariffPlanService {
	TariffPlan Tobj = new TariffPlan();

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAlien(@PathParam("id") String id) {
		double[] arr = Tobj.GetTariffPlan(id);


		return arr[0] + "," + arr[1];
	}

	@POST
	@Path("/Add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String CreateTariffPlan(@FormParam("ET_ID") String ET_ID, @FormParam("Tariff_Block") String Tariff_Block,
			@FormParam("Unit_Rate") double Unit_Rate, @FormParam("Fixed_Charge") double Fixed_Charge) {

		double Ur = (double) Math.round(Unit_Rate * 100) / 100;
		double Fc = (double) Math.round(Fixed_Charge * 100) / 100;


		return Tobj.CreateTariffPlan(ET_ID, Tariff_Block, Ur, Fc);

	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteTariffPlans(String XmlData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(XmlData, "", Parser.xmlParser());
		// Read the value from the element <ID> and <MID>

		String ID = doc.select("ID").text();

		return Tobj.DeleteTariffPlan(ID);
	}

	@PUT
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String UpdateTariffPlan(@FormParam("ET_ID") String ET_ID, @FormParam("Tariff_Block") String Tariff_Block,
			@FormParam("Unit_Rate") double Unit_Rate, @FormParam("Fixed_Charge") double Fixed_Charge) {

		double Ur = (double) Math.round(Unit_Rate * 100) / 100;
		double Fc = (double) Math.round(Fixed_Charge * 100) / 100;

		return Tobj.UpdateTariffPlan(ET_ID, Tariff_Block, Ur, Fc);

	}

}
