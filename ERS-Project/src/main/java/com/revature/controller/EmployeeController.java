package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementRequest;
import com.revature.services.EmployeeServices;

public class EmployeeController {
	
	List<ReimbursementRequest> requests = new ArrayList<>();
	EmployeeServices empServices = new EmployeeServices();
	
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/employee/".length()).split("/");
		String username = parts[0];
		String choice = parts[1];		
		if(parts.length == 0) {
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
		} else {
			// get request by Username
			switch(choice) {
			case "pending": 
				try {
					List<ReimbursementRequest> userPendingRequests = empServices.getPendingRequestsByUsername(username);
					if(userPendingRequests.isEmpty()) {
						response.sendError(404);
					}
					ObjectMapper om = new ObjectMapper();
					om.writeValue(response.getWriter(), userPendingRequests);
					
				}catch (NumberFormatException e) {
					System.out.println("No costume found");
					
					// could assume that this is the name
					response.sendError(404);
					return;
				}
				break;
			case "processed":
				try {
					List<ReimbursementRequest> userCompletedRequests = empServices.getProcessedRequestsByUsername(username);
					if(userCompletedRequests.isEmpty()) {
						response.sendError(404);
					}
					ObjectMapper om = new ObjectMapper();
					om.writeValue(response.getWriter(), userCompletedRequests);
					
				}catch (NumberFormatException e) {
					System.out.println("No costume found");
					
					// could assume that this is the name
					response.sendError(404);
					return;
				}
				break;
			}
			
			
			
			
		}
	}
	
	
	
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		ObjectMapper om = new ObjectMapper();
//		ReimbursementRequest rr = om.readValue(request.getReader(),rr.class);
//		rr = EmployeeServices.getProcessedRequestsByUsername(rr);
//		om.writeValue(response.getWriter(), rr);
	}

}
