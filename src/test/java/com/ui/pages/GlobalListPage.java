package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pojo.GlobalDetailsPojo;
import com.util.BrowserUtility;

public class GlobalListPage extends BrowserUtility {
    
	private static final By TABLE_DATA_LOCATOR = By.xpath("//mat-table/mat-row/mat-cell");
	
	public GlobalListPage(ChromeDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}
    
	public GlobalDetailsPojo getJobDetails() {
		sleepFor(5);
		List<String> dataList =  getListOfVisibleText(TABLE_DATA_LOCATOR);
		GlobalDetailsPojo data = new GlobalDetailsPojo(dataList.get(0), dataList.get(1), dataList.get(2), dataList.get(3), dataList.get(4), dataList.get(5), dataList.get(6));
		return data;
	}
	
	
	
}
