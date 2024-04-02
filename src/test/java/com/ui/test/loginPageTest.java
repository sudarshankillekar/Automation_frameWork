package com.ui.test;

import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.DashBoardPage;
import com.ui.pages.GlobalListPage;
import com.ui.pages.loginpage;

public class loginPageTest  {
 	
	public static void main(String[] args) {
		
		ChromeDriver wd = new ChromeDriver();
		loginpage onLoginpage = new loginpage(wd);
		onLoginpage.sleepFor(30);
		DashBoardPage dashBoardPage = onLoginpage.dologinwith("iamqc", "password");
		GlobalListPage globalListPage = dashBoardPage.searchForJobUsing("JOB_28957");
		System.out.println(globalListPage.getJobDetails());
	}

}
