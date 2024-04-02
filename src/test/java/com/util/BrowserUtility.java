package com.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v109.browser.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtility {

	private ChromeDriver wd;

	public ChromeDriver getWd() {
		return wd;
	}

	public BrowserUtility() {

	}

	public BrowserUtility(ChromeDriver wd) {
		this.wd = wd;
	}

	public void launchBrowser() {
		wd = new ChromeDriver();
	}

	public void goToWebSite(String enterUrl) {
		wd.get(enterUrl);
	}
    
	public void maximizeBrowserWindow() {
		
	}
	
	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterTextInto(By locator, String textToEnter) {
		WebElement element = wd.findElement(locator);
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
		WebElement element = wd.findElement(locator);
		element.clear();
	}

	public void clickOn(By locator) {
		WebElement element = wd.findElement(locator);
		element.click();
	}

	public String getVisibleText(By locator) {
		WebElement element = wd.findElement(locator);
		return element.getText();
	}

	public List<String> getListOfVisibleText(By locator) {
		List<WebElement> elementsList = wd.findElements(locator);
		List<String> visibleTextList = new ArrayList<>();
		String data;
		for (WebElement element : elementsList) {
			data = element.getText();
			visibleTextList.add(data);
		}
		//System.out.println(visibleTextList);
		return visibleTextList;
	}

	public int getVisibleIntValue(By locator) {
		WebElement element = wd.findElement(locator);
		String data = element.getText();
		int value = Integer.parseInt(data);
		return value;
	}

	public void enterSpecialKey(By locator, Keys specialKey) {
		WebElement element = wd.findElement(locator);
		element.sendKeys(specialKey);
	}

	public void selectFromDropDown(By locatorDropDown, String value) {
		clickOn(locatorDropDown);
		By optionLocator = By.xpath("//span[contains(text(),\"" + value + "\")]/..");
		sleepFor(3);
		clickOn(optionLocator);
	}

	public List<WebElement> getAllText(By locator) {
		List<WebElement> elementlist = wd.findElements(locator);
		return elementlist;
	}
    
}
