package com.ui.pages;

import java.util.function.Predicate;

import com.ui.pojo.GlobalDetailsPojo;

public class jobfilter implements Predicate<GlobalDetailsPojo> {

	private String jobNumber;
	
	public jobfilter(String jobNumber) {
		super();
		this.jobNumber = jobNumber;
	}
	
	@Override
	public boolean test(GlobalDetailsPojo t) {
		// TODO Auto-generated method stub
		if(t.getJobNumber().equalsIgnoreCase(jobNumber)) {
		return true;
		}
		else {
			return false;
		}
		
	}

	
	
}
