package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.BrowserUtility;

public final class loginpage extends BrowserUtility{
	
	private static final By USERNAMETEXRBOXLOCATOR = By.id("username");
	private static final By PASSWORDTEXRBOXLOCATOR = By.id("password");
	private static final By LOGINBUTTONLOCATOR = By.xpath("//span[contains(text(),\" Sign in \")]/../..");
	
	public loginpage(ChromeDriver wd) {
		super(wd);
		goToWebSite("http://phoenix.testautomationacademy.in/sign-in");
	}
    



	public DashBoardPage dologinwith(String userName, String password) {
		clearText(USERNAMETEXRBOXLOCATOR);		
		enterTextInto(USERNAMETEXRBOXLOCATOR, userName);
		clearText(PASSWORDTEXRBOXLOCATOR);
		enterTextInto(PASSWORDTEXRBOXLOCATOR, password);
		clickOn(LOGINBUTTONLOCATOR);	
		return new DashBoardPage(getWd());
	}
	
}
