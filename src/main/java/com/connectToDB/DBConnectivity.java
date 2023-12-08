package com.connectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {

	private static Connection connection;
	private static DBConnectivity dbConnectivity ;
	
	private DBConnectivity() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(dbConnectivity ==null) {
			dbConnectivity = new DBConnectivity();			
		}
		return connection;
	}
	 
	
}
