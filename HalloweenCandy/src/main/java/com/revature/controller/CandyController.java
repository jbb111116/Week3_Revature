package com.revature.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Candy;

public class CandyController {
	
	List<Candy> candies = new ArrayList<>();
	{
		candies.add(new Candy(0,"twix","caramel, chocolate, cookie",
				"chocolate bar", true, true, 2, new BigDecimal(2)));
	}
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// localhost:8080/HalloweenCandy/candy?candy=1
		String param = request.getParameter("candy");
		ObjectMapper mapper = new ObjectMapper();
		if(param == null) {
			// Send all candies
//			response.getWriter().write(candies.toString());
			mapper.writeValue(response.getWriter(), candies);
		} else {
			// Sends one candy.
			int id = Integer.parseInt(param);
			mapper.writeValue(response.getWriter(), candies.get(id));
//			response.getWriter().write(candies.get(id));
		}
		
	}

	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Candy candy = mapper.readValue(request.getReader(), Candy.class);
		candy.setId(candies.size()-1);
		candies.add(candy);
		System.out.println("Added candy: " + candy);
		mapper.writeValue(response.getWriter(), candy);
		
//		candies.add(request.getParameter("candy"));
//		response.getWriter().write(request.getParameter("candy") 
//				+ " added with id " + (candies.size()-1));
	}
	
	
}