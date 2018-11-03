package com.revature.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Logistics {
	public static int correctInput(int num1, int num2) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		// Catches any errors
		while (choice < num1 || choice > num2) {
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
			}
			else {
				try {
					choice = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input");
					sc.nextLine();
				}
			}
		}
		return choice;
	}
	
	public static Timestamp javaTimeToSqlTime(Date javaTime) {
		Timestamp ts = new Timestamp(javaTime.getTime());
		return ts;
	}
	
	public static Date sqlTimeToJavaTime(Timestamp sqlTime) {
		Date date = new Date(sqlTime.getTime());
		return date;
	}
}
