package com.revature.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

import com.revature.services.Logistics;

public class Instantiations {
	public static User promptCreateEmployee() {
		User emp = new User();
		return emp;
	}
	
	// this function is going to be modified depending on the user input in the front end.
	public static ReimbursementRequest newRequest() {
		Scanner sc = new Scanner(System.in);
		int reimb_id = 0;
		System.out.println("amount");
		BigDecimal amount = sc.nextBigDecimal();
		Date resolved = null;
		System.out.println("author");
		int author_id = Logistics.correctInput(0, 4);
		System.out.println("discript");
		sc.nextLine();
		String description = sc.nextLine();
		System.out.println("type");
		int type_id = Logistics.correctInput(0, 3);
		int resolver_id = 0;
		int status_id = 1;
		Date submitted = null;
		
		ReimbursementRequest request = new ReimbursementRequest(reimb_id,amount,submitted,resolved, description,author_id,resolver_id,status_id,type_id);
		return request;
	}
}
