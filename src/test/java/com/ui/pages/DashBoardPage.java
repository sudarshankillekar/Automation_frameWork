package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pojo.GlobalDetailsPojo;
import com.util.BrowserUtility;

public class DashBoardPage extends BrowserUtility {

	private static final By SEARCH_TEXT_BOX_LOCATOR = By.xpath("//input[@placeholder = \"Search for a Job or IMEI\"]");
	private static final By CREATED_JOB_BUTTON__LOCATOR = By.xpath("//div[contains(text(),'Created today')]/../div/button");
	private static final By TABLE_LOCATOR = By.xpath("//mat-table/mat-row/mat-cell");
	public DashBoardPage(ChromeDriver wd) {
		super(wd);
	}
	
	public  GlobalListPage searchForJobUsing(String imeiOrNumber) {
		sleepFor(5);
		enterTextInto(SEARCH_TEXT_BOX_LOCATOR, imeiOrNumber);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		return new GlobalListPage(getWd());
	}
	
	public DashBoardPage openJobCreatedTodayTable() {
		sleepFor(5);
		clickOn(CREATED_JOB_BUTTON__LOCATOR);
		return new DashBoardPage(getWd());
	}
	
	public boolean searchForjob(String jobNumber) {
		sleepFor(5);
		List<WebElement> rowList = getWd().findElements(TABLE_LOCATOR);
		GlobalDetailsPojo globalDetailsPojo;
		ArrayList<GlobalDetailsPojo> dataList = new ArrayList<>();
		for(WebElement row : rowList) {
			List<WebElement> cellList = row.findElements(By.xpath(".//mat-cell"));
			globalDetailsPojo = new GlobalDetailsPojo(cellList.get(0).getText(), cellList.get(1).getText(), cellList.get(2).getText(), cellList.get(3).getText(), cellList.get(4).getText(), cellList.get(5).getText(), cellList.get(6).getText());
		 dataList.add(globalDetailsPojo);
		}
		
		List<GlobalDetailsPojo> resultList = dataList.stream().filter(new jobfilter(jobNumber)).toList();
		System.out.println(resultList);
		if(resultList.size()>0) {
			return true;
		}
		else
		{
			return false;
		}
		
	}

}