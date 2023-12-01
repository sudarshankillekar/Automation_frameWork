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
        ResultSet result  =  statement.executeQuery("SELECT *FROM SR_DEV.student WHERE id  = 1001;");
       // StudentPOJO studentPOJO2;
        while(result.next()) {
        	 StudentPOJO studentPOJO21 = new StudentPOJO(result.getString(1), result.getInt(2), result.getInt(3));
        }
        
//        System.out.println(StudentPOJO.getName());
	}

}
