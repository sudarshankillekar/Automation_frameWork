package com.connectToDB;

import java.util.Date;

public class Runner {

	public static void main(String[] args) {
	mst_warrenty_status_DAO mst_warrenty_status_DAO = new mst_warrenty_status_DAO(); 
	mst_warrenty_status_pojo mst_warrenty_status_data = mst_warrenty_status_DAO.getmst_warrenty_status_byID(2);
	System.out.println(mst_warrenty_status_data);
	
	  Date currentDate = new Date();
	//mst_warrenty_status_pojo mst_warrenty_status_pojo = new mst_warrenty_status_pojo(3, "jus", "other", "in_warrenty", 3);
	mst_warrenty_status_pojo mst_warrenty_status_pojo = new mst_warrenty_status_pojo(1, "test", "test", "test", 2, currentDate, currentDate );
	mst_warrenty_status_DAO.insert_emst_warrenty_status_Data(mst_warrenty_status_pojo) ;
//	tes
	//t
//jj	
}
}