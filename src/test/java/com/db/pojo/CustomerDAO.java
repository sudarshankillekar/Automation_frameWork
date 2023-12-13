package com.db.pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.dao.DBConnectivity;

public class CustomerDAO {
    private TR_Customer_pojo tr_Customer_pojo;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public CustomerDAO() {
		connection = DBConnectivity.getConnection();
	}
	
	public TR_Customer_pojo getcustomerrecordsfromtheDB(int customerId)  {
		try {
			statement = connection.createStatement();
			resultSet  = statement.executeQuery("SELECT id, first_name, last_name, mobile_number, mobile_number_alt, email_id, email_id_alt, tr_customer_address_id, is_active, created_at, modified_at\r\n"
					+ "FROM tr_customer\r\n"
					+ "WHERE id= "+customerId+";");
			
			while(resultSet.next()) {
				tr_Customer_pojo = new TR_Customer_pojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tr_Customer_pojo;
	}
}
