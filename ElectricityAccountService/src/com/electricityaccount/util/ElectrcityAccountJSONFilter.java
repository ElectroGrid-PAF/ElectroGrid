package com.electricityaccount.util;

import org.json.JSONArray;
import org.json.JSONObject;


// Used to filter bill json object by its key value pairs
public class ElectrcityAccountJSONFilter {

	JSONObject jsonObj;
	JSONArray filteredArr;

	public ElectrcityAccountJSONFilter() {
		jsonObj = new JSONObject();
		filteredArr = new JSONArray();
	}

	public JSONArray filterbyAccountID(JSONArray jsonArr, String accID) {

		// iterate jsonArray using for loop   
		for (int i = 0; i < jsonArr.length(); i++) {  

			// store each object in JSONObject  
			jsonObj = jsonArr.getJSONObject(i);  

			// get field value from JSONObject using get() method  
			if(accID.equals(jsonObj.get("Account_ID"))){
				filteredArr.put(jsonObj);
			}
		} 

		return filteredArr;
	}

	public JSONArray filterbyDate(JSONArray jsonArr, String year) {

		// iterate jsonArray using for loop   
		for (int i = 0; i < jsonArr.length(); i++) {  

			// store each object in JSONObject  
			jsonObj = jsonArr.getJSONObject(i);  

			// get field value from JSONObject and compare 
			if(jsonObj.get("Issued_Date").toString().contains(year)){
				filteredArr.put(jsonObj);
			}
		} 

		return filteredArr;
	}
}
