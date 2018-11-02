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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Origin", "*");
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
	
	
	static Route getRoute(HttpServletRequest request) {
		
		return null;
	}
	
	void writeStaticFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getNamedDispatcher("default");
		HttpServletRequest wrapped = new HttpServletRequestWrapper(request) {
			
		};
		rd.forward(wrapped, response);
	}
	
}
