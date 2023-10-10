package com.noCommerceVFinal.testcases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.noCommerceVFinal.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig= new ReadConfig();
	
	String url=readconfig.getBaseUrl();
	
	public String browser=readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup() {
		
		if(browser.equals("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=null;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		//for logging
		logger=LogManager.getLogger("noCommerceVFinal");
		
		driver.get(url);  // for every test case it is a common thing so we have used in setup method
		logger.info("url opened");
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void captureScreenShot(WebDriver driver, String testName) throws Exception {
		
		//step 1: convert webDriver object to TakesScreenshot interface
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		// step 2: calling getScreenshotAs method to create image file
		
		File src =screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest =new File("./Screenshots/"+testName+".png");
		
		// step 3: copy image file to destination
		
		FileUtils.copyFile(src, dest);
	}
}
