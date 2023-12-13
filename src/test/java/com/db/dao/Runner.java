package com.db.dao;

import java.util.Date;

public class Runner {

	public static void main(String[] args) {
	
	
	Employee_DAO employee_DAO = new Employee_DAO();
	EmployeePOJO employeePOJO_data = employee_DAO.get_employe_id_byID(2);
	System.out.println(employeePOJO_data);
	EmployeePOJO insertdata = new EmployeePOJO(5, "sudarshan", "IT", 43000);
	employee_DAO.insert_employee_Data(insertdata);
	System.out.println(insertdata);
	
	
	

}
	
}