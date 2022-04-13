package com.Egrid.Ereadings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class BillGenerateClient {
	private double Units;
	private static String baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E001";

	static String testGet() {

		WebResource resource = getWebResource();
		String output = resource.get(String.class);

		return output;

	}

	static WebResource getWebResource() {
		Client client = Client.create();

		WebResource resource = client.resource(baseURI);

		return resource;
	}

	public String read(int i) {
		if (i == 2) {
			baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E002";

		}
		if (i == 3) {
			baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E003";

		}
		if (i == 4) {
			baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E004";

		}
		if (i == 5) {
			baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E005";

		}
		return testGet();

	}

}
