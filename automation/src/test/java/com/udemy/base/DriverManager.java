package com.udemy.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.udemy.config.Property;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public WebDriver driver;

	public WebDriver driverSetUp(String browser, String url) {
		if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
	    	driver.get(url);
	    	driver.manage().window().maximize();
		  }

		  else if(browser.equalsIgnoreCase("chrome")){
			  
			  WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
			     	driver.get(url);
		    	driver.manage().window().maximize();
			  }
	    	return driver;
		
	}

}
