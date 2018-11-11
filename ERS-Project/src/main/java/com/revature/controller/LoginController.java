package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;

public class LoginController {

	
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies(); 
		
		if (cookies != null) {
		        for (Cookie cookie : cookies) {
		                cookie.setValue(null);
		                cookie.setMaxAge(0);
		                response.addCookie(cookie);
		        }
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		ManagerServices manServices = new ManagerServices();
		EmployeeServices empServices = new EmployeeServices();
		
		
		User user = mapper.readValue(request.getReader(), User.class);
		if(user.getRole()==2) {
			User responseVar = manServices.manLogin(user.getUsername(), user.getPassword());
			if(responseVar.getUsername().isEmpty()) {
				mapper.writeValue(response.getWriter(),"Invalid password/username!" );
			} else {
				Cookie usernameCookie = new Cookie("username",user.getUsername());
				usernameCookie.setMaxAge(15*60);
				response.addCookie(usernameCookie);
				System.out.println(usernameCookie.getName() + ": " + usernameCookie.getValue());
				System.out.println("usernameCookie added!");
				String id = Integer.toString(responseVar.getUser_id());
				Cookie IdCookie = new Cookie("user_id", id);
				IdCookie.setMaxAge(15*60);
				response.addCookie(IdCookie);
				System.out.println(IdCookie.getName() + ": " + IdCookie.getValue());
				System.out.println("IdCookie added!");
				mapper.writeValue(response.getWriter(),"Welcome!");
			}
			
		}
		else if(user.getRole()==1) {
			String responseVar = empServices.empLogin(user.getUsername(), user.getPassword());
			if(responseVar.length()==0) {
				mapper.writeValue(response.getWriter(),"Invalid password/username!" );
			} else {
				mapper.writeValue(response.getWriter(), "Welcome!");
				Cookie usernameCookie = new Cookie("username",user.getUsername());
				Cookie IdCookie = new Cookie("id", Integer.toString(user.getUser_id()));
				response.addCookie(usernameCookie);
				response.addCookie(IdCookie);
			}
		}
		
		
		
		
	}
}
