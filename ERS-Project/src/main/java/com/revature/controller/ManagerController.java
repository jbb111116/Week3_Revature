package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementRequest;
import com.revature.models.User;
import com.revature.services.ManagerServices;

public class ManagerController {
	
	List<ReimbursementRequest> requests = new ArrayList<>();
	ManagerServices manServices = new ManagerServices();
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String uri = request.getRequestURI();
		String[] parts = uri.substring("/ERS-Project/manager/".length()).split("/");
		String username = parts[0];
		String choice = parts[1];		
		if(parts.length == 0) {
			// get all requests
			try {
				List<ReimbursementRequest> requests = manServices.getAllRequests();
				
				if(requests.isEmpty()) {
					System.out.println("Requests not found");
					response.sendError(404);
				}
				ObjectMapper om = new ObjectMapper();
				om.writeValue(response.getWriter(), requests);
				
			}catch (NumberFormatException e) {
				System.out.println("Requests found");
				
				// could assume that this is the name
				response.sendError(404);
				return;
			}
		}
		else if(parts[1].isEmpty()) {
			try {
				List<ReimbursementRequest> allUserRequests = manServices.getAllRequestsByUsername(username);
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
			// get request by Username given a certain username.
			switch(choice) {
			case "pending": 
				try {
					List<ReimbursementRequest> requests = manServices.getPendingRequestsByUsername(username);
					if(requests.isEmpty()) {
						response.sendError(404);
					}
					ObjectMapper om = new ObjectMapper();
					om.writeValue(response.getWriter(), requests);
					
				}catch (NumberFormatException e) {
					System.out.println("No costume found");
					
					// could assume that this is the name
					response.sendError(404);
					return;
				}
				break;
			case "processed":
				try {
					List<ReimbursementRequest> requests = manServices.getProcessedRequestsByUsername(username);
					if(requests.isEmpty()) {
						response.sendError(404);
					}
					ObjectMapper om = new ObjectMapper();
					om.writeValue(response.getWriter(), requests);
					
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
		ManagerServices manServices = new ManagerServices();
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getReader(), User.class);
		manServices.login(user.getUsername(), user.getPassword());
		
		
	}
}
