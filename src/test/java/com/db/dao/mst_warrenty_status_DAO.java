package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectToDB.DBConnectivity;
import com.connectToDB.mst_warrenty_status_pojo;

public class mst_warrenty_status_DAO {
	
	private Connection connection;
	private Statement statement;

	
	public mst_warrenty_status_DAO() {
	//connection to DB will happen
        connection = DBConnectivity.getConnection();
        
        try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	

