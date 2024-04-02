package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.BrowserUtility;

public class DashBoardPage extends BrowserUtility {

	private static final By SEARCH_TEXT_BOX_LOCATOR = By.xpath("//input[@placeholder = \"Search for a Job or IMEI\"]");
	
	public DashBoardPage(ChromeDriver wd) {
		super(wd);
	}
	
	public  GlobalListPage searchForJobUsing(String imeiOrNumber) {
		sleepFor(5);
		enterTextInto(SEARCH_TEXT_BOX_LOCATOR, imeiOrNumber);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		return new GlobalListPage(getWd());
	}
}
