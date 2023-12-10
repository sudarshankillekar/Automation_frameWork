package com.connectToDB;

public class EmployeePOJO {
	    private int employeeId;
	    private String employeeName;
	    private String department;
	    private double salary;

	

	    // Parameterized constructor
	    public EmployeePOJO(int employeeId, String employeeName, String department, double salary) {
	        super();
	    	this.employeeId = employeeId;
	        this.employeeName = employeeName;
	        this.department = department;
	        this.salary = salary;
	    }

	    // Getters and Setters for each field
	    public int getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(int employeeId) {
	        this.employeeId = employeeId;
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
	                "employeeId=" + employeeId +
	                ", employeeName='" + employeeName + '\'' +
	                ", department='" + department + '\'' +
	                ", salary=" + salary +
	                '}';
	    }
}
