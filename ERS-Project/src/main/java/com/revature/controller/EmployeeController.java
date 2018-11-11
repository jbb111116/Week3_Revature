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
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;

public class EmployeeController {
	
	List<ReimbursementRequest> requests = new ArrayList<>();
	EmployeeServices empServices = new EmployeeServices();
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/employee/".length()).split("/");
		String username = parts[0];
		
		// Getting cookies after Login
		Cookie[] cookies = request.getCookies();
		
		// Makes sure once logged into a user, you can't switch
		if(username.equals(cookies[0])) {
			// employee/username/
			if(parts.length == 1) {
				// get all requests
				try {
					List<ReimbursementRequest> allUserRequests = empServices.getAllRequestsByUsername(username);
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
			} else if(parts.length == 2) {
				String choice = parts[1];
				switch(choice) {
				case "pending":
					try {
						List<ReimbursementRequest> allUserRequests = empServices.getPendingRequestsByUsername(username);
						ObjectMapper om = new ObjectMapper();
						if(allUserRequests.isEmpty()) {
							System.out.println("Requests not found");
							om.writeValue(response.getWriter(), "All requests have been processed!");
							response.sendError(404);
						}
						om.writeValue(response.getWriter(), allUserRequests);
						
					}catch (NumberFormatException e) {
						System.out.println("Requests found");
						
						// could assume that this is the name
						response.sendError(404);
						return;
					}
				case "processed":
					try {
						List<ReimbursementRequest> allUserRequests = empServices.getProcessedRequestsByUsername(username);
						ObjectMapper om = new ObjectMapper();
						if(allUserRequests.isEmpty()) {
							System.out.println("Requests not found");
							om.writeValue(response.getWriter(), "No requests have been processed.");
						}
						om.writeValue(response.getWriter(), allUserRequests);
						
					}catch (NumberFormatException e) {
						System.out.println("Requests found");
						
						// could assume that this is the name
						response.sendError(404);
						return;
					}
					break;
				}
			}
			else {
				System.out.println("Invalid URL");
				response.sendError(404);
			}
		}
		
	}
	
	
	// Employee will be able to create new request
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Getting cookies after Login
		Cookie[] cookies = request.getCookies();
		
		ObjectMapper mapper = new ObjectMapper();
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/employee/".length()).split("/");
		String username = parts[0];
		if(username.equals(cookies[0])) {
			String choice = parts[1];
			if(choice.equals("new-request")) {
				ReimbursementRequest newRequest = mapper.readValue(request.getReader(), ReimbursementRequest.class);
				// Sets the authorId for a new request.
				newRequest.setAuthor_id(Integer.parseInt(cookies[1].getValue()));
				if(!(newRequest.getAmount().toString().isEmpty()) && !(newRequest.getDescription().isEmpty()) &&
						!(Integer.toString(newRequest.getType_id()).isEmpty())) {
					ReimbursementRequest submittedRequest = empServices.submitRequest(newRequest);
					mapper.writeValue(response.getWriter(),submittedRequest);
				}
			}
		}
	}

}
