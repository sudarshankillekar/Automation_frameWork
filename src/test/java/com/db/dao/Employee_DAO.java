package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectToDB.mst_warrenty_status_pojo;

public class Employee_DAO {
	
	private EmployeePOJO employeePOJO;
	private Connection connection;
	private Statement statement;
	
	public Employee_DAO() {
		//connection to DB will happen
		try {
		     connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
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
				//  mst_warrenty_status = new mst_warrenty_status_pojo(result.getInt(1), result.getString("name"),result.getString("code"), result.getString("description"), result.getInt(1),result.getDate("created_at"),result.getDate("modified_at"));
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
