package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.connectToDB.mst_warrenty_status_pojo;

public class Employee_DAO2 {
	
	private EmployeePOJO employeePOJO;
	private Connection connection;
	private Statement statement;
	
	public Employee_DAO2() {
		//connection to DB will happen
		connection = DBConnectivity.getConnection();
		 try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EmployeePOJO get_employe_id_byID(int id) {
		  try {
			ResultSet result  =  statement.executeQuery("SELECT *FROM SR_DEV.employee WHERE employee_id = "+id+";");
			while(result.next()) {
				employeePOJO = new EmployeePOJO(result.getInt(1), result.getString("Employee_name"),result.getString("department"), result.getDouble(4));
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		return employeePOJO;
	}
   
	public boolean insert_employee_Data(EmployeePOJO employeePOJO) {
		boolean status = false;
		  try {
				 //status  =  statement.execute("INSERT INTO SR_DEV.mst_warrenty_status(id, name, code, description, is_active, created_at, modified_at)VALUES("+mst_warrenty_status.getId()+", "+mst_warrenty_status.getName()+", "+mst_warrenty_status.getCode()+", "+mst_warrenty_status.getDescription()+", "+mst_warrenty_status.getDescription()+");");
				 status  =  statement.execute("INSERT INTO SR_DEV.employee(employee_id, employee_name, department, salary)VALUES(\" " +employeePOJO.getemployee_id()+"\",\" "+employeePOJO.getEmployeeName()+"\", \" "+employeePOJO.getDepartment()+"\", "+employeePOJO.getSalary()+");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return status;
	}
	
	
	
}
