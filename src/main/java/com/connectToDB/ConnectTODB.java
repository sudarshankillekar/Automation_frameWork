package com.connectToDB;

import com.connectToDB.StudentPOJO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTODB {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
        Statement statement = connection.createStatement();
        ResultSet result  =  statement.executeQuery("SELECT *FROM SR_DEV.mst_warrenty_status WHERE id =2 ;");
        mst_warrenty_status_pojo warrenty_status = null;
        while(result.next()) {
        	 warrenty_status = new mst_warrenty_status_pojo(result.getInt(1), result.getString("name"),result.getString("code"), result.getString("description"), result.getInt(1));
        }
        
       System.out.println(warrenty_status);
	}

}
