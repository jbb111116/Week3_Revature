package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementRequest;

public class ManagerController {
	
	List<ReimbursementRequest> requests = new ArrayList<>();
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		
		ObjectMapper mapper = new ObjectMapper();
	}
	
	public void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		ObjectMapper mapper = new ObjectMapper();
	}
}
