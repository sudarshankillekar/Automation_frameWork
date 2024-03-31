package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.browser.model.Bucket;
import com.util.BrowserUtility;

public class loginPage extends BrowserUtility{
	
	private static final By userNameTexrBoxLocator = By.id("username");
	private static final By passwordTexrBoxLocator = By.id("password");
	private static final By loginButtonLocator = By.xpath("//span[contains(text(),\" Sign in \")]/../..");
	
	public loginPage() {
		// TODO Auto-generated constructor stub
	}
    
 public static void main(String[] args) {
	    ChromeDriver wd = new ChromeDriver();
		BrowserUtility bu = new BrowserUtility(wd);
		bu.goToWebSite("http://phoenix.testautomationacademy.in/sign-in");
		bu.clearText(userNameTexrBoxLocator);
		
		bu.enterTextInto(userNameTexrBoxLocator, "iamfd");
		bu.clearText(passwordTexrBoxLocator);
		bu.enterTextInto(passwordTexrBoxLocator, "password");
		bu.clickOn(loginButtonLocator);
		
}
	
	
	 
	
	
}
