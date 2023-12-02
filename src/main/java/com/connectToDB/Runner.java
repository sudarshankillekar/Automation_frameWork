package com.connectToDB;


public class Runner {

	public static void main(String[] args) {
	mst_warrenty_status_DAO mst_warrenty_status_DAO = new mst_warrenty_status_DAO(); 
	mst_warrenty_status_pojo mst_warrenty_status_data = mst_warrenty_status_DAO.getmst_warrenty_status_byID(2);
	System.out.println(mst_warrenty_status_data);
	}
	
}
