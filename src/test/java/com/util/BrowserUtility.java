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

	private WebDriver wd;
	private WebDriverWait wait;

	MutableCapabilities capabilities = new MutableCapabilities();

	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	private static final String USERNAME = "jatinsharma_9AC1Mq";
	private static final String AUTOMATE_KEY = "66izqd4iLxyu1pYsziWb";
	private static final String REMOTE_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub.browserstack.com/wd/hub";;

	public WebDriver getWd() {
		return wd;
	}

	public BrowserUtility() {
	}

	public BrowserUtility(WebDriver wd) {
		this.wd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}

	public BrowserUtility(WebDriver wd, int timeToWaitSec) {
		this.wd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(timeToWaitSec));
	}

	public BrowserUtility(String machine) {
		if (machine.equalsIgnoreCase("Remote")) {
			capabilities.setCapability("browserName", "Safari");
			HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
			browserstackOptions.put("os", "OS X");
			browserstackOptions.put("osVersion", "Ventura");
			browserstackOptions.put("browserVersion", "16.0");
			browserstackOptions.put("local", "false");
			browserstackOptions.put("seleniumVersion", "3.14.0");
			capabilities.setCapability("bstack:options", browserstackOptions);
			try {
				wd = new RemoteWebDriver(new URL(REMOTE_URL), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		}

	}

	public void launchBrowser() {
		wd = new ChromeDriver();
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}

	public void goToWebSite(String enterUrl) {
		wd.get(enterUrl);
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
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}

	public void clickOn(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public String getVisibleText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}

	public List<String> getListOfVisibleText(By locator) {
		List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		List<String> visibleTextList = new ArrayList<>();
		String data;
		for (WebElement element : elementsList) {
			data = element.getText();
			visibleTextList.add(data);
		}
		System.out.println(visibleTextList);
		return visibleTextList;
	}

	public int getVisibleIntValue(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String data = element.getText();
		int value = Integer.parseInt(data);
		return value;
	}

	public void enterSpecialKey(By locator, Keys specialKey) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		;
		element.sendKeys(specialKey);
	}

	public void selectFromDropDown(By locatorDropDown, String value) {
		clickOn(locatorDropDown);
		By optionLocator = By.xpath("//span[contains(text(),\"" + value + "\")]/..");
		clickOn(optionLocator);
	}

	public void closeSession() {
		wd.quit();
	}

}
