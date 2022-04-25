package com.example.payment.resource;
import com.example.payment.model.paymentmodel;
import com.example.payment.service.paymentservice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/payment")
public class paymentresource {
	paymentservice service = new paymentservice();
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public paymentmodel addPayment(paymentmodel payment) {
		return service.insertPayment(payment);
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<paymentmodel>  getPayment() throws SQLException {
		 return service.getPayment();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<paymentmodel>  getPayment(@PathParam("id") int id) throws SQLException {
		return service.getPaymentById(id);
		
	}
	

	
	@Path("/updatePayment")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public paymentmodel updatePayment(paymentmodel payment) {
		 return service.updatetPayment(payment);
		
	}
	
	@Path("/deletePaymentById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deletePayment(@PathParam("id") int id) {
		return service.deletetPayment(id);
		
	}
}
