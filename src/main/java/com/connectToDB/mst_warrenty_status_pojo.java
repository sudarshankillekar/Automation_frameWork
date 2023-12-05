package com.connectToDB;


import java.util.Date;
public class mst_warrenty_status_pojo {
  
	int id;
	String name;
	String code;
	String description ;
	int is_active;
	private Date created_at; // Date for created_at
    private Date modified_at; // Date for modified_at
	
	
	public mst_warrenty_status_pojo(int id, String name, String code, String description, int is_active, Date created_at,Date modified_at) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.is_active = is_active;
	    this.created_at = created_at;
	    this.modified_at = modified_at;
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
	
    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }


	@Override
	public String toString() {
		return "mst_warrenty_status [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", is_active=" + is_active +", created_at=" + created_at +
                ", modified_at=" + modified_at + "]";
	}
	
	
	
}
