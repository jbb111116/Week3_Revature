package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.controller.EmployeeController;
import com.revature.controller.ManagerController;
import com.revature.controller.Route;

public class DispatcherServlet extends DefaultServlet {
	EmployeeController empController = new EmployeeController();
	ManagerController manController = new ManagerController();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		super.service(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Route route = getRoute(request);

		switch (route) {
		case MANAGER:
			manController.get(request, response);
			break;
		case EMPLOYEE:
			empController.get(request, response);
			break;
		case STATIC:
			writeStaticFile(request,response); 
			break;
		case NOT_FOUND:
		default: response.setStatus(404);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Route route = getRoute(request);
		
		switch(route) {
			case MANAGER: manController.post(request, response); break;
			case EMPLOYEE: empController.post(request, response); break;
			case NOT_FOUND:
			default: response.setStatus(404);
		}
	}
	
	//1
	static Route getRoute(HttpServletRequest request) {
		String suffix = request.getRequestURI().substring("/ERS-Project/".length());
		String routeString = suffix.split("/")[0];
		try {
			return Route.valueOf(routeString.toUpperCase());
		} catch(IllegalArgumentException e) {
			return Route.NOT_FOUND;
			}
	}
	//1
	
	void writeStaticFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getNamedDispatcher("default");
		HttpServletRequest wrapped = new HttpServletRequestWrapper(request) {
			public String getServletPath() { return "";}
			
		};
		rd.forward(wrapped, response);
	}
	
}
