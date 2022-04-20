package com.Egrid.Ereadings;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class BillGenerateClient {
	private static String baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E001";

	static String testGet() {

		WebResource resource = getWebResource();

		return resource.get(String.class);

	}

	static WebResource getWebResource() {
		Client client = Client.create();

		return client.resource(baseURI);
	}

	public String read(int i) {

		// Assigning BaseURI to get values (Unit Rates , Fixed Charge) from the API

		// change this lile
		if (i == 1) {
			baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E001";

		}
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
