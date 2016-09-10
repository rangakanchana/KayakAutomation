package com.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.util.TakeScreenShotUtil;

public class KayakAuto {
		WebDriver driver;
	
	@Test
	public void openKayakPage(){
		
	driver = new FirefoxDriver();
	
	driver.get("https://www.kayak.com/");
	
	driver.manage().window().maximize();
	
	TakeScreenShotUtil.captureScreenShot(driver,"BrowserStarted");
	
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
	
	driver.findElement(By.linkText("Flights")).click();
	
	String parentWindow = driver.getWindowHandle();
	
	Set<String> handles = driver.getWindowHandles();
	
	for(String childWindow : handles){
		
		if(!childWindow.equals(parentWindow)){
			
			driver.switchTo().window(childWindow);

		}
	}
	
	WebElement from = driver.findElement(By.name("origin"));
		
	from.clear();
	
	Actions act = new Actions(driver);
	
	Actions actionsFro =  act.keyDown(from, Keys.SHIFT).sendKeys("sfo");
	
	TakeScreenShotUtil.captureScreenShot(driver,"TypeDeparture");
	
	actionsFro.sendKeys(Keys.ENTER).build().perform();
	
	WebElement to = driver.findElement(By.name("destination"));
	
	Actions actionsTo = act.keyDown(to, Keys.SHIFT).sendKeys("iad");
	
	TakeScreenShotUtil.captureScreenShot(driver,"TypeDestination");
	
	actionsTo.sendKeys(Keys.ENTER).build().perform();
	
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
	WebElement element = driver.findElement(By.xpath("//span[@class='r9-datepicker-placeholder']"));
	
	element.click();
	
	
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	driver.findElement(By.xpath(".//*[@id='datepicker']/div[3]/span[2]/span[2]/span[3]/span[1]/span")).click();	
    
    driver.findElement(By.xpath(".//*[@id='datepicker']/div[4]/span[2]/span[2]/span[3]/span[1]/span")).click();
    
	TakeScreenShotUtil.captureScreenShot(driver,"EnterDate");

    
    driver.findElement(By.linkText("1 adult, Economy")).click();
    
    driver.findElement(By.xpath("//span[@class='icon plus']")).click();
    
    WebElement search = driver.findElement(By.xpath("//div[@class='fieldBlock buttonBlock']/button"));
    
    JavascriptExecutor js = (JavascriptExecutor)driver;
    
    js.executeScript("arguments[0].click()", search);
    
    TakeScreenShotUtil.captureScreenShot(driver,"ClickSearch");

 }
 }
