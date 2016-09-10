package com.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShotUtil {
	
	
public static void captureScreenShot(WebDriver driver,String screenShotName){
	
	try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./Screenshots/"+screenShotName+".png"));
		
		System.out.println("screenshot taken");
	
	} catch (Exception e) {
System.out.println("exception while taking screenshot"+e.getMessage());
}
}
}
