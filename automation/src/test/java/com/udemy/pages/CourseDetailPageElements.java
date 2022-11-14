package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.udemy.base.CommonFunctions;
import com.udemy.base.DriverFunction;
import com.udemy.base.DriverManager;

public class CourseDetailPageElements {
	WebDriver pagedriver;
	DriverFunction driverFunctions = new DriverFunction();
	CommonFunctions commonFunc = new CommonFunctions();
	public  CourseDetailPageElements(WebDriver driver) {
		
		pagedriver=driver;
		PageFactory.initElements( driver, this);
		
	}

	@FindBy(xpath="//h1[@data-purpose='lead-title']")
	public WebElement CourseTitle;
	
	@FindBy(xpath="(//div[@data-purpose='buy-box']//div[@data-purpose='add-to-cart'])[1]")
	public WebElement AddToCartBtn;
	
	@FindBy(xpath="//div[@data-purpose='cart-success-modal']")
	public WebElement AddToCartPopUp;
	
	@FindBy(xpath="//button[@data-purpose='go-to-cart-button']")
	public WebElement GoToCartBtn;
	
	
	
	public void clickAddToCartButton() {
		driverFunctions.Click(pagedriver,AddToCartBtn, 20);
		commonFunc.printConsole("clicked Add To Cart Button");
		
	}
	
	public void clickGoToCartButton() {
		driverFunctions.Click(pagedriver,GoToCartBtn, 20);
		commonFunc.printConsole("clicked Go To Cart Button");
		
	}
	
	
	public void VerifyCourseNameInCourseDetailPage(String CourseName) {
		driverFunctions.WaitUntilElementVisible(pagedriver,CourseTitle, 20);
		WebElement CourseTitleName=pagedriver.findElement(By.xpath("//h1[contains(text(),'"+CourseName+"')]"));
		commonFunc.VerifyElementDisplay(CourseTitleName, "CourseName is displayed in Course detail page");
		
	}
	
	public void VerifyCourseNameInAddedToCartPopUp(String CourseName) {
		driverFunctions.WaitUntilElementVisible(pagedriver,AddToCartPopUp, 20);
		WebElement CourseTitleName=pagedriver.findElement(By.xpath("//div[@data-purpose='cart-success-modal']//div[contains(text(),'"+CourseName+"')]"));
		commonFunc.VerifyElementDisplay(CourseTitleName, "CourseName is displayed in the add to cart pop up");
		
	}
	
	
	
	
		
}
