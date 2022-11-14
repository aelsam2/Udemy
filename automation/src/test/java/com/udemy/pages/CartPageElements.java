package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udemy.base.CommonFunctions;
import com.udemy.base.DriverFunction;
import com.udemy.base.DriverManager;

public class CartPageElements {
	WebDriver pagedriver;
	DriverFunction driverFunctions = new DriverFunction();
	CommonFunctions commonFunc = new CommonFunctions();
	public  CartPageElements(WebDriver driver) {
		
		pagedriver=driver;
		PageFactory.initElements( driver, this);
		
	}

	@FindBy(xpath="//a[@data-purpose='shopping-course-card-title']")
	public WebElement CourseTitle;
	
	@FindBy(xpath="//a[contains(text(),'Move to Wishlist')]")
	public WebElement MoveToWishListBtn;
	
	
	
	
	
	public void clickMoveToWishListButton() {
		driverFunctions.Click(pagedriver,MoveToWishListBtn, 20);
		commonFunc.printConsole("clicked Move To WishList Button");
		
	}
	
	
	
	public void VerifyCourseNameInCartTab(String CourseName) {
		driverFunctions.WaitUntilElementVisible(pagedriver, CourseTitle, 20);
		WebElement CourseTitleName=pagedriver.findElement(By.xpath("//h3[@data-purpose='cart-list-title']//ancestor::div//div[contains(text(),'"+CourseName+"')]"));
		commonFunc.VerifyElementDisplay(CourseTitleName, "CourseName is displayed in the cart tab");
		
	}
	
	public void VerifyCourseNameInCWishListedTab(String CourseName) {
		driverFunctions.WaitUntilElementVisible(pagedriver,CourseTitle, 20);
		WebElement CourseTitleName=pagedriver.findElement(By.xpath("//h3[@data-purpose='wishlist-list-title']//ancestor::div//div[contains(text(),'"+CourseName+"')]"));
		commonFunc.VerifyElementDisplay(CourseTitleName, "CourseName is displayed in the wish listed tab");
		
	}
	
	
	
	
		
}

