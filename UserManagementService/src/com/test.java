//package com;
//
//import java.lang.reflect.Method; 
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//import javax.annotation.security.RolesAllowed;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.ResourceInfo;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//
//import model.AuthifiationUser;
//
//import javax.annotation.security.DenyAll;
//import javax.annotation.security.PermitAll;
//
//@Provider
//public class AuthSecurityFilter implements ContainerRequestFilter {
//	
//	public static final String AUTHENTICATION_HEADER_KEY = "Authorization";
//	public static final String AUTHENTICATION_HEADER_PREFIX = "Basic ";
//
// //private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());;
////    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());;
////    private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<Object>());;
////     
//	
//	@Context
//	private ResourceInfo resourceInfo;
//
//	
//	@Override
//	public void filter(ContainerRequestContext requestContext) throws IOException {
//		// TODO Auto-generated method stub
//	
//		List<String> authHeader = requestContext.getHeaders().get(AUTHENTICATION_HEADER_KEY);
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
//			authToken = authToken.replaceFirst(AUTHENTICATION_HEADER_PREFIX, "");
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
//	                if( ! AuthifiationUser.is_User_Allowed_Access(username, password, rolesSet))
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
//}



//package com;
//
//import java.io.IOException;
//
//import java.util.List;
//import java.util.StringTokenizer;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//
//import org.glassfish.jersey.internal.util.Base64;
//
//@Provider
//public class SecurityFilter implements ContainerRequestFilter {
//
//	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
//	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
//	private static final String SECURED_URL_PREFIX = "secured";
//
//	@Override
//	public void filter(ContainerRequestContext requestContext) throws IOException {
//		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
//
//			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
//
//			if (authHeader != null && authHeader.size() > 0) {
//				String authToken = authHeader.get(0);
//				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
//			String decodedString = Base64.decodeAsString(authToken);
//
//			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
//				String username = tokenizer.nextToken();
//				String password = tokenizer.nextToken();
//
//				if ("user".equals(username) && "password".equals(password)) {
//					return;
//				}
//		}
//			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access this resource").build();
//			requestContext.abortWith(unauthorizedStatus);
//		}
//
//	}
//}





