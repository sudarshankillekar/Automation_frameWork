package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.BrowserUtility;

public final class loginpage extends BrowserUtility{
	
	private static final By USERNAMETEXRBOXLOCATOR = By.id("username");
	private static final By PASSWORDTEXRBOXLOCATOR = By.id("password");
	private static final By LOGINBUTTONLOCATOR = By.xpath("//span[contains(text(),\" Sign in \")]/../..");
	
	public loginpage(WebDriver wd) {
		super(wd);
		goToWebSite("http://phoenix.testautomationacademy.in/sign-in");
	}
    
	public loginpage(ChromeDriver wd) {
		// TODO Auto-generated constructor stub
	}


	public void dologinwith(String userName, String password) {
		clearText(USERNAMETEXRBOXLOCATOR);		
		enterTextInto(USERNAMETEXRBOXLOCATOR, userName);
		clearText(PASSWORDTEXRBOXLOCATOR);
		enterTextInto(PASSWORDTEXRBOXLOCATOR, password);
		clickOn(LOGINBUTTONLOCATOR);		
	}
	
}
