package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			case "processed":
				try {
					List<ReimbursementRequest> allUserRequests = empServices.getProcessedRequestsByUsername(username);
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
				break;
			case "new-request":
				// Working on it
				break;
			}
		}
		else {
			System.out.println("INvalid URL");
			response.sendError(404);
		}
		
	}
	
	
	
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EmployeeServices empServices = new EmployeeServices();
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getReader(), User.class);
		String responseVar = empServices.login(user.getUsername(), user.getPassword());
		if(responseVar.length()==0) {
			mapper.writeValue(response.getWriter(),"Invalid password/username!" );
		} else {
			mapper.writeValue(response.getWriter(), "Welcome!");
		}
	}

}
