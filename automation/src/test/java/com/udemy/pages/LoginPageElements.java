package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udemy.base.CommonFunctions;
import com.udemy.base.DriverFunction;
import com.udemy.base.DriverManager;

public class LoginPageElements{
	WebDriver pagedriver;
	DriverFunction driverFunctions = new DriverFunction();
	CommonFunctions commonFunc = new CommonFunctions();
	public  LoginPageElements(WebDriver driver) {
		
		pagedriver=driver;
		PageFactory.initElements( driver, this);
		
	}

	@FindBy(xpath="//input[@name='email']")
	public WebElement EmailField;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement PasswordField;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement SubmitBtn;
	

	
	
	
	public void EnterEmail(String EmailID) {
		driverFunctions.SendKeys(pagedriver,EmailField, 20, EmailID);
		commonFunc.printConsole("Entered Email");
		
	}
	public void EnterPassword(String Password) {
		driverFunctions.SendKeys(pagedriver,PasswordField, 20, Password);
		commonFunc.printConsole("Entered Password");
		
	}
	public void ClickSubmitButton() {
		driverFunctions.Click(pagedriver,SubmitBtn, 20);
		commonFunc.printConsole("Clicked Submit Button");
		
	}
	
	

	
	
		
}
