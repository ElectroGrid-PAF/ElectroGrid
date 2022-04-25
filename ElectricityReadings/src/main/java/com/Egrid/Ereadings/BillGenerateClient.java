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
		baseURI = "http://localhost:8080/ElectricityTariffPlan/webapi/Plans/E00"+i;

		return testGet();

	}

}
