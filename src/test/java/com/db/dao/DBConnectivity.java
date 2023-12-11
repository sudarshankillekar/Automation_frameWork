package com.db.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.util.Testutility;

import static com.util.Testutility.*;
public class DBConnectivity {

	private static Connection connection;
	private static DBConnectivity dbConnectivity ;
	
	private DBConnectivity() {
		try {
			 try {
				connection = DriverManager.getConnection(Testutility.getPropertFrom("qa.properties", "DB_URL"), Testutility.getPropertFrom("qa.properties", "DB_USER_NAME"), Testutility.getPropertFrom("qa.properties", "DB_PASSWORD"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
