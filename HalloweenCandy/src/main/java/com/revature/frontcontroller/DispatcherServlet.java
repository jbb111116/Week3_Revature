package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.controller.CandyController;
import com.revature.controller.ContainerController;
import com.revature.controller.CostumesController;
import com.revature.controller.Route;

public class DispatcherServlet extends DefaultServlet {
	
	CandyController candyController = new CandyController();
	ContainerController containerController = new ContainerController();
	CostumesController costumesController = new CostumesController();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Route route = getRoute(request);
		
		switch(route) {
			case CANDY: candyController.get(request, response); break;
			case CONTAINER: containerController.get(request, response); break;
			case COSTUMES: costumesController.get(request, response);break;
			case STATIC: writeStaticFile(request, response); break;
			case NOT_FOUND:
			default: response.setStatus(404);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Route route = getRoute(request);
		
		switch(route) {
			case CANDY: candyController.post(request, response); break;
			case CONTAINER: containerController.post(request, response); break;
			case COSTUMES: costumesController.post(request,response); break;
			case NOT_FOUND:
			default: response.setStatus(404);
		}
	}
	
	static Route getRoute(HttpServletRequest request) {
		String suffix = request.getRequestURI().substring("/HalloweenCandy/".length());
		String routeString = suffix.split("/")[0];
		try {
			return Route.valueOf(routeString.toUpperCase());
		} catch(IllegalArgumentException e) {
			return Route.NOT_FOUND;
		}
	}
	
	void writeStaticFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getNamedDispatcher("default");
		HttpServletRequest wrapped = new HttpServletRequestWrapper(request) {
			public String getServletPath() { return ""; }
		};
		rd.forward(wrapped, response);
	}
}
