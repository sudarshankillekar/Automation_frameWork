package com.api.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import groovyjarjarantlr4.v4.parse.ANTLRParser.action_return;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
public class Flipkart {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to your ChromeDriver
    

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
  //      WebDriverWait wait = new WebDriverWait(driver, 10);
        // Implicit wait to manage elements loading time
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open Flipkart website
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        // Search for a product (change 'phone' to your desired product)
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("APPLE iPhone 14 (Blue, 128 GB)");
        searchBox.submit();
        Thread.sleep(4000);
        // Click on the first item from the list
        WebElement firstItem = driver.findElement(By.xpath("(//div[normalize-space()='APPLE iPhone 14 (Blue, 128 GB)'])[1]"));
        firstItem.click();
        driver.manage().window().maximize();

        // Get the price of the item
        String Ptab = driver.getWindowHandle();
        System.out.println(Ptab);
        WebElement priceElement = driver.findElement(By.xpath("//div[contains(text(),'₹58,999')]"));
        String priceBeforeAdding = priceElement.getText();
        System.out.println("Price before addition: " + priceBeforeAdding);
        for(String Ctab : driver.getWindowHandles()) {
        	driver.switchTo().window(Ctab);
        }
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        
   //      Add to cart in guest mode
        WebElement addToCartButton = driver.findElement(By.cssSelector("._2KpZ6l._2U9uOA._3v1-ww"));
        addToCartButton.click();
//        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='GO TO CART']")));
//        addToCartButton.click();
        // Increase the quantity by 1
        
        Thread.sleep(5000);
//        Actions actions = new Actions(driver);
//        actions.click(driver.findElement(By.xpath("//div[@class='_26HdzL']")))
//        .keyDown(Keys.CONTROL)
//        .sendKeys("2")
//        .keyUp(Keys.CONTROL)
//        .sendKeys(Keys.BACK_SPACE)
//        .build()
//        .perform();
        WebElement increaseQuantity = driver.findElement(By.xpath("//input[@value='1']"));
        increaseQuantity.clear();
        increaseQuantity.sendKeys("2");
        
        
      
        // Get the price after increasing quantity
        Thread.sleep(5000);
        WebElement priceAfterAdditionElement = driver.findElement(By.cssSelector("div[class='Ob17DV _3X7Jj1'] span"));
        String priceAfterAdding = priceAfterAdditionElement.getText();
        System.out.println("Price after addition: " + priceAfterAdding);

        // Close the browser
//        driver.quit();
    }
}

