package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementRequest;
import com.revature.models.User;
import com.revature.services.ManagerServices;

public class ManagerController {
	
	List<ReimbursementRequest> requests = new ArrayList<>();
	ManagerServices manServices = new ManagerServices();
	
	// Manager will be able to view requests based on category
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/manager/".length()).split("/");
		String manUsername = parts[0];
		
		// Getting cookies after Login
		Cookie[] cookies = request.getCookies();
		
		// manager/username/status/user
		String choice = parts[1];
			switch(choice) {
			case "pending":
				if(parts.length <= 3) {
					if(parts.length == 2 ) {
						try {
							List<User> users = manServices.listOfUsers();
							ObjectMapper om = new ObjectMapper();
							om.writeValue(response.getWriter(), users);
							
						}catch (NumberFormatException e) {
							System.out.println("Requests not found");
							
							// could assume that this is the name
							response.sendError(404);
							return;
						}
						
					}
					else if( parts.length == 3){
						String username = parts[2];
						if(!(username.equals(manUsername))){
							try {
								List<ReimbursementRequest> allUserRequests = manServices.getPendingRequestsByUsername(username);
								if(allUserRequests.isEmpty()) {
									System.out.println("Requests not found");
									response.sendError(404);
								}
								ObjectMapper om = new ObjectMapper();
								om.writeValue(response.getWriter(), allUserRequests);
								
							}catch (NumberFormatException e) {
								System.out.println("Requests found");
								
								// could assume that this is the name
								response.sendError(404);
								return;
							}
						}
						else {
							ObjectMapper om = new ObjectMapper();
							om.writeValue(response.getWriter(),"No requests found.");
						}
					}
				}
				break;
			case "processed":
				if(parts.length <= 3) {
					if(parts.length == 2) {
						try {
							List<User> users = manServices.listOfUsers();
							ObjectMapper om = new ObjectMapper();
							om.writeValue(response.getWriter(), users);
							
						}catch (NumberFormatException e) {
							System.out.println("Requests not found");
							
							// could assume that this is the name
							response.sendError(404);
							return;
						}
						
					}
					else if(parts.length == 3) {
						String username = parts[2];
						if(!(username.equals(manUsername))) {
							try {
								List<ReimbursementRequest> allUserRequests = manServices.getProcessedRequestsByUsername(username);
								if(allUserRequests.isEmpty()) {
									System.out.println("Requests not found");
									response.sendError(404);
								}
								ObjectMapper om = new ObjectMapper();
								om.writeValue(response.getWriter(), allUserRequests);
								
							}catch (NumberFormatException e) {
								System.out.println("Requests found");
								
								// could assume that this is the name
								response.sendError(404);
								return;
							}
						}
						else {
							ObjectMapper om = new ObjectMapper();
							om.writeValue(response.getWriter(),"No requests found.");
						}
					}
				}
				break;
			case "new-request":
				// Working on it
				break;
			}
	}
	
	// Manager will be able to create request
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Getting cookies after Login
		Cookie[] cookies = request.getCookies();
		
		ObjectMapper mapper = new ObjectMapper();
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/manager/".length()).split("/");
		String username = parts[0];
		String choice = parts[1];
		if(choice.equals("new-request")) {
			ReimbursementRequest newRequest = mapper.readValue(request.getReader(), ReimbursementRequest.class);
			
			// Sets the authorId for a new request.
			newRequest.setAuthor_id(Integer.parseInt(cookies[1].getValue()));
			ReimbursementRequest submittedRequest = manServices.submitRequest(newRequest);
			mapper.writeValue(response.getWriter(),submittedRequest);
		}
		
	}
		
	// Manager will be able to approve/deny requests
	public void put(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ReimbursementRequest pendingRequest = mapper.readValue(request.getReader(), ReimbursementRequest.class);
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/manager/".length()).split("/");
		String resolvingUser = parts[0];
		
	}
}
