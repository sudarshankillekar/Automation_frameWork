package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectToDB.mst_warrenty_status_pojo;

public class mst_warrenty_status_DAO {
	
	private mst_warrenty_status_pojo mst_warrenty_status;
	private Connection connection;
	private Statement statement;
	
	public mst_warrenty_status_DAO() {
		//connection to DB will happen
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
			 Statement statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public mst_warrenty_status_pojo getmst_warrenty_status_byID(int id) {
		  try {
			ResultSet result  =  statement.executeQuery("SELECT *FROM SR_DEV.mst_warrenty_status WHERE id =" + id + "\"");
			while(result.next()) {
				  mst_warrenty_status = new mst_warrenty_status_pojo(result.getInt(1), result.getString("name"),result.getString("code"), result.getString("description"), result.getInt(1));
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		return mst_warrenty_status;
	}
   
	public void Updatemst_warrenty_status_Data(mst_warrenty_status_pojo mst_warrenty_status) {
		
	}
	
	
	
}
