package com.udemy.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommonFunctions {
	 
	  public void printConsole(String sMessage) {
		  System.out.println(new SimpleDateFormat("dd-M-yyy hh:mm:ss").format(new Date())+" - "+sMessage);
	  }
	  public  void VerifyElementDisplay( WebElement element, String sMessage)
		{
		  boolean b=element.isDisplayed();
		  compareBoolean(b);
		  printConsole(sMessage);
		}
	  public void compareBoolean(boolean flag) {
		 if(flag=true)
			 printConsole("Boolean passed");
		 else
			 printConsole("Boolean Failed");
	  }
}
