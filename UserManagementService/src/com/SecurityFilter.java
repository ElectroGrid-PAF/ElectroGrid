package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import Util.DBConnection;
import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secured";

	private Connection connect() { 
		Connection con = null; 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usermanagementservice", "root", ""); 
			//For testing
			System.out.print("Successfully connected to the database!"); 
		} 
		catch (Exception e) {
			System.out.print("Failed to connect to the databse!"); 
			e.printStackTrace();
		} 
		return con; 
	 }
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			
		
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

			if (authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.decodeAsString(authToken);

			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":"); 
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				Connection con = connect(); 
				boolean result = false; 
				String sql = "select * from user where Username = ? and Password = ?";
				PreparedStatement ps;
				try {
				ps = con.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				result = rs.next();
				} catch (SQLException e) {
				e.printStackTrace();
				}
				
				if (result){
					return;
				}
					
				
		}
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access this resource").build();
			requestContext.abortWith(unauthorizedStatus);
		}
	}
}


//package com;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.StringTokenizer;
//import java.lang.reflect.Method; 
//import java.util.List;
//import java.util.StringTokenizer;
//
//import javax.annotation.security.DenyAll;
//import javax.annotation.security.PermitAll;
//import javax.annotation.security.RolesAllowed;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//import javax.ws.rs.container.ResourceInfo;
//
//
//@Provider
//public class SecurityFilter implements ContainerRequestFilter {
//
//	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
//	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
//	//private static final String SECURED_URL_PREFIX = "secured";
//
//	@Context
//	private ResourceInfo resourceInfo;
//	
//	@Override
//	public void filter(ContainerRequestContext requestContext) throws IOException {
//		// TODO Auto-generated method stub
//	
//		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
//		
//		Method method = resourceInfo.getResourceMethod();
//		
//		 if( ! method.isAnnotationPresent(PermitAll.class))
//	        {
//			//Access denied for all
//	            if(method.isAnnotationPresent(DenyAll.class))
//	            {
//	            	Response unauthoriazedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("{\"Attention 2!\" : \"You are not authorized to Use this service\"}").build();
//	            		
//	            	requestContext.abortWith(unauthoriazedStatus);
//	            
//	            }
//		if(authHeader != null && authHeader.size() > 0 ) {
//			
//			String authToken = authHeader.get(0);
//			
//			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
//			
//			String decodedString = "";
//			
//			try {
//				byte[] decodedBytes = Base64.getDecoder().decode(authToken);
//				decodedString = new String(decodedBytes, "UTF-8");
//			
//			} catch (IOException e) {
//			
//				e.printStackTrace();
//			}
//			final StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
//			
//			
//			
//			final String username = tokenizer.nextToken();
//			
//			final String password = tokenizer.nextToken();
//			
//			
//			 if(method.isAnnotationPresent(RolesAllowed.class))
//	            {
//	                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
//	                
//	                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
//	                  
//	                //Is user valid?
//	 
//	                if( ! AuthUser.is_User_Allowed_Access(username, password, rolesSet))
//	                {
//	                	Response unauthoriazedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("{\"Attention 3!\" : \"Access denied for this resource\"}").build();
//	                	
//	                	requestContext.abortWith(unauthoriazedStatus);
//	                   
//	                }
//	                return;
//	            }
//			
//		}
//	        
//	        }
//		 
//		Response unauthoriazedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("{\"Attention 1!\" : \"You are not authorized to Use this service\"}").build(); 
//		
//		requestContext.abortWith(unauthoriazedStatus);
//	        
//	}
//
//
//	
//}
//
//
//
//
//
