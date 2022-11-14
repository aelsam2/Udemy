package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udemy.base.CommonFunctions;
import com.udemy.base.DriverFunction;
import com.udemy.base.DriverManager;

public class HomePageElements{
	WebDriver pagedriver;
	DriverFunction driverFunctions = new DriverFunction();
	CommonFunctions commonFunc = new CommonFunctions();
	public  HomePageElements(WebDriver driver) {
		
		pagedriver=driver;
		PageFactory.initElements( driver, this);
		
	}

	@FindBy(xpath="//a[@data-purpose='header-login']")
	public WebElement LoginBtn;
	
	@FindBy(xpath="//input[@placeholder='Search for anything']")
	public WebElement SearchForAnythingField;
	
	@FindBy(xpath="//a[@aria-label='My profile']")
	public WebElement ProfileIcon;
	
	@FindBy(xpath="//a[@aria-label='My profile']")
	public WebElement FirstSearchResultFromList;
	
	
	public void clickLoginButton() {
		driverFunctions.Click(pagedriver,LoginBtn, 20);
		commonFunc.printConsole("clicked Login Button");
		
	}
	
	public void EnterSearchValueInMasterSearchFieldAndClickEnter(String SearchValue) {
		driverFunctions.SendKeysWithEnter(pagedriver,SearchForAnythingField, 20,SearchValue);
		commonFunc.printConsole("Entered Search Value In Master Search Field");
		
	}
	
	public void VerifyMasterSearchResultInTheResult(String SearchValue) {
		driverFunctions.WaitUntilElementVisible(pagedriver,FirstSearchResultFromList, 20);
		WebElement SearchResult=pagedriver.findElement(By.xpath("//h3/a[contains(text(),'"+SearchValue+"')]"));
		commonFunc.VerifyElementDisplay(SearchResult, "Search result is displayed");
		
	}
	
	public void ClickSearchResultInTheResult(String SearchValue) {
		driverFunctions.WaitUntilElementVisible(pagedriver,FirstSearchResultFromList, 20);
		WebElement SearchResult=pagedriver.findElement(By.xpath("//h3/a[contains(text(),'"+SearchValue+"')]"));
		driverFunctions.Click(pagedriver,SearchResult, 20);
		commonFunc.printConsole("Clicked the seach result");
	}
	
	
	public void VerifyUserLogin() {
		driverFunctions.WaitUntilElementVisible(pagedriver,ProfileIcon, 20);
		commonFunc.VerifyElementDisplay(ProfileIcon, "Profile Icon is present (Login is successfull)");
		
	}
	
	
		
}
