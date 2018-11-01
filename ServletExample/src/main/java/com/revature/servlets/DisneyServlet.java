package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlets.DefaultServlet;

import com.revature.services.DisneyService;

/**
 * Servlet implementation class DisneyServlet
 */
public class DisneyServlet extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	private DisneyService disneyService = new DisneyService();
       
    /**
     * @see DefaultServlet#DefaultServlet()
     */
    public DisneyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Forwarding to another servlet
//		System.out.println("Forwarding from Disney to Hello World");
//		getServletContext().getRequestDispatcher("/hello/").forward(request, response);
		
		// Redirecting
//		response.sendRedirect("http://google.com/");
//		response.setHeader("Location", "http://www.google.com");
//		response.setStatus(302);
		
		
		String uri = request.getRequestURI();
		String movie = uri.substring("/ServletExample/DisneyServlet/".length()).split("/")[0];
		String character = disneyService.getCharacter(movie);
		response.getWriter().write(character);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String manipulation to get String array with [0] the movie and [1] the character
		String uri = request.getRequestURI();
		String[] arr = uri.substring("/ServletExample/DisneyServlet/".length()).split("/");
		
		// Check to ensure that array is big enough
		if(arr.length < 2) {
			response.setStatus(400);
			return;
		}
		// Call service method
		disneyService.setCharacter(arr[0], arr[1]);
		
		// Tell the client everything was good
		response.setStatus(201);
	}
	
	/**
	 * The lifecycle of a servlet has three steps:
	 * 1. init - initializing the servlet - called once
	 * 2. service - handling a request - called once for every request
	 * 3. destroy - end of servlet lifecycle, shutting down - called once (or never)
	 */
	
	public void init() {
		System.out.println("Disney Servlet Initializing");
	}
	
	public void destroy() {
		System.out.println("Disney Servlet Shutting Down");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
