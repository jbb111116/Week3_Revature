package com.revature.controller;


import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ContainerController {
	
	
	
	public void get(HttpServletRequest request ,HttpServletResponse response) {
		// Get cookies from request - cookies sent by the client
		Cookie[] cookies = request.getCookies();
		if(!(cookies==null || cookies.length < 1)) {
			for(Cookie cookie: cookies) {
				System.out.println(cookie.getName() + ": " + cookie.getValue());
			}
			
		}
		
		
//------------------- Run these two first as a GET method.-------------------------------
//		Cookie cookie = new Cookie("my-cookie", "test-value");
		
//		response.addCookie(cookie);
//---------------------------------------------------------------------------------------
//		Cookie cookie = new Cookie("my-cookie", "super-test-value");
//		response.addCookie(cookie);
		
		
		/*
		 * Session 
		 * A session is intended to identify a user who is sending request.
		 * Sessions collect key value paris which can then be accessed between requests
		 * This allows us to store info about a user throughout the lifetime of 
		 * session.
		 * How it works:
		 * Java produced a cookie called the JSESSIONID that contains a unique token
		 * This token is then provided on future request, which identifies which value
		 * map should be provided for the session.
		 * Limitations:
		 * 1. Session information is stored in memory, this means when the app shuts down
		 * , the session and all session data are lost.
		 * 2. Also due to information being stored in memory, this makes app stateful.
		 * The application must store data for individual users in memory. As a consequence,
		 * the memory requirements of the app will grow with the number of users.
		 * This results in an app that will not scale well
		 */
		request.getSession(false);
		HttpSession session = request.getSession();
		session.setAttribute("name", "mitch");
		
		
	}
	/**
	 * Print out what is included in the request body
	 * @throws IOException 
	 */
	
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		// Getting the session object
		HttpSession session = request.getSession();
		// Getting the value store with the key 'name'
		String name = (String) session.getAttribute("name"); 
		//Print out a message using 'name'
		System.out.println("Message from " + name); // expectation: Message for mitch
		
		String line = null;
		while((line = request.getReader().readLine()) != null) {
			System.out.println(line);
		}
		
	}
}
