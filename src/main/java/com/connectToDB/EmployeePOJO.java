package com.connectToDB;

public class EmployeePOJO {
	    private int employee_id;
	    private String employeeName;
	    private String department;
	    private double salary;

	

	    // Parameterized constructor
	    public EmployeePOJO(int employee_id, String employeeName, String department, double salary) {
	        super();
	    	this.employee_id = employee_id;
	        this.employeeName = employeeName;
	        this.department = department;
	        this.salary = salary;
	    }

	    // Getters and Setters for each field
	    public int getemployee_id() {
	        return employee_id;
	    }

	    public void setemployee_id(int employee_id) {
	        this.employee_id = employee_id;
	    }

	    public String getEmployeeName() {
	        return employeeName;
	    }

	    public void setEmployeeName(String employeeName) {
	        this.employeeName = employeeName;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public void setDepartment(String department) {
	        this.department = department;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    // Override toString method for object representation
	    @Override
	    public String toString() {
	        return "Employee{" +
	                "employee_id=" + employee_id +
	                ", employeeName='" + employeeName + '\'' +
	                ", department='" + department + '\'' +
	                ", salary=" + salary +
	                '}';
	    }
}
