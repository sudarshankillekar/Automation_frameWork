package com.connectToDB;

public class StudentPOJO {
	
	private int name;
	private int id;
	private int marks;
	public StudentPOJO(int name, int id, int marks) {
		super();
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "StudentPOJO [name=" + name + ", id=" + id + ", marks=" + marks + "]";
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	

}
