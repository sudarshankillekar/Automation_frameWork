package com.connectToDB;

public class mst_warrenty_status_pojo {

	int id;
	String name;
	String code;
	String description ;
	int is_active;
	
	
	public mst_warrenty_status_pojo(int id, String name, String code, String description, int is_active) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.is_active = is_active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	@Override
	public String toString() {
		return "mst_warrenty_status [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", is_active=" + is_active + "]";
	}
	
	
	
}
