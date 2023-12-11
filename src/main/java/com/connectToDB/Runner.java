package com.connectToDB;

import java.util.Date;

public class Runner {

	public static void main(String[] args) {
	mst_warrenty_status_DAO mst_warrenty_status_DAO = new mst_warrenty_status_DAO(); 
	mst_warrenty_status_pojo mst_warrenty_status_data = mst_warrenty_status_DAO.getmst_warrenty_status_byID(2);
	System.out.println(mst_warrenty_status_data);
	
	Employee_DAO employee_DAO = new Employee_DAO();
	EmployeePOJO employeePOJO_data = employee_DAO.get_employe_id_byID(2);
	System.out.println(employeePOJO_data);
	EmployeePOJO insertdata = new EmployeePOJO(5, "sudarshan", "IT", 43000);
	employee_DAO.insert_employee_Data(insertdata);
	System.out.println(insertdata);
	
	
	

}
	
}