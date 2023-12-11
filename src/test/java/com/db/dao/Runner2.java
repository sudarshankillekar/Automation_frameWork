package com.db.dao;





public class Runner2 {

	public static void main(String[] args) {
	
	
	Employee_DAO2 employee_DAO = new Employee_DAO2();
	EmployeePOJO employeePOJO_data = employee_DAO.get_employe_id_byID(2);
	System.out.println(employeePOJO_data);
	EmployeePOJO insertdata = new EmployeePOJO(6, "sudarshan", "IT", 43000);
	employee_DAO.insert_employee_Data(insertdata);
	System.out.println(insertdata);
	
	
	

}
	
}