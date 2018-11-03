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
		if(parts.length == 0) {
			// get all requests
			
		} else {
			
			// get request by Username
			String username = parts[0];
//			int id = 0;
			
//			try {
////				id = Integer.parseInt(username);
//				List<ReimbursementRequest> userPendingRequests = empServices.getPendingRequestsByUsername(username);
//				if(userPendingRequests == null) {
//					response.sendError(404);
//				}
//				ObjectMapper om = new ObjectMapper();
//				om.writeValue(response.getWriter(), userPendingRequests);
//				
//			}catch (NumberFormatException e) {
//				System.out.println("No costume found");
//				
//				// could assume that this is the name
//				response.sendError(404);
//				return;
//			}
			try {
//				id = Integer.parseInt(username);
				List<ReimbursementRequest> userProcessedRequests = empServices.getPendingRequestsByUsername(username);
				if(userProcessedRequests.isEmpty()) {
					System.out.println("Requests not found");
					response.sendError(404);
				}
				ObjectMapper om = new ObjectMapper();
				om.writeValue(response.getWriter(), userProcessedRequests);
				
			}catch (NumberFormatException e) {
				System.out.println("Requests found");
				
				// could assume that this is the name
				response.sendError(404);
				return;
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
