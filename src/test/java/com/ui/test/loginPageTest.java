package com.ui.test;

import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.loginpage;

public class loginPageTest  {
 
	private loginpage loginpage;
	
	public static void main(String[] args) {
		ChromeDriver wd = new ChromeDriver();
		loginpage onloginpage = new loginpage(wd);
		onloginpage.dologinwith("iamqc", "password");
	}

}
