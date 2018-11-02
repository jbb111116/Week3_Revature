package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() {
		
		try {
			String url = "jdbc:postgresql://anotherclassdb.cwgm7vdywa98.us-east-2.rds.amazonaws.com:5432/anotherClassDB";
			String username = "jDawg";
			String password = "456210somethingelse";
			return DriverManager.getConnection(url, username , password);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
