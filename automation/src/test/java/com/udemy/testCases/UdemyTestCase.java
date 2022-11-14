package com.udemy.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.udemy.base.DriverManager;
import com.udemy.config.Property;
import com.udemy.pages.CartPageElements;
import com.udemy.pages.CourseDetailPageElements;
import com.udemy.pages.HomePageElements;
import com.udemy.pages.LoginPageElements;
import com.udemy.testData.TestData;


public class UdemyTestCase extends DriverManager {
	WebDriver driver;
	String userName=Property.userName;
	String password=Property.password;
	LoginPageElements loginPageElems;
	HomePageElements homePageElems;
	CourseDetailPageElements courseDetailPageElems;
	CartPageElements cartPageElems;
	//String CourseName="String CourseName";
	

	@Test( dataProvider="AddCourseToWishListBySeachingtheCourse",dataProviderClass = TestData.class,description ="Login into udemy.com,"
			+ "Search for a specific course (eg: The Complete JavaScript Course 2022: From Zero to Expert!),"
			+ " Add to the cart, Goto cart and move the item into the Wishlist.", enabled =true)
	 
	  public void AddCourseToWishListBySeachingtheCourse(String CourseName) throws InterruptedException {
		loginPageElems = new LoginPageElements(driver);
		homePageElems = new HomePageElements(driver);
		courseDetailPageElems = new CourseDetailPageElements(driver);
		cartPageElems = new CartPageElements(driver);
		homePageElems.clickLoginButton();
		loginPageElems.EnterEmail(userName);
		loginPageElems.EnterPassword(password);
		loginPageElems.ClickSubmitButton();
		homePageElems.VerifyUserLogin();
		homePageElems.EnterSearchValueInMasterSearchFieldAndClickEnter(CourseName);
		homePageElems.VerifyMasterSearchResultInTheResult(CourseName);
		homePageElems.ClickSearchResultInTheResult(CourseName);
		courseDetailPageElems.VerifyCourseNameInCourseDetailPage(CourseName);
		courseDetailPageElems.clickAddToCartButton();
		courseDetailPageElems.VerifyCourseNameInAddedToCartPopUp(CourseName);
		courseDetailPageElems.clickGoToCartButton();
		cartPageElems.VerifyCourseNameInCartTab(CourseName);
		cartPageElems.clickMoveToWishListButton();
		cartPageElems.VerifyCourseNameInCWishListedTab(CourseName);
	}
	
	 @Parameters({"browser", "AppUrl"})
	 @BeforeClass
	 public void beforeClass(String browser, String url)throws IOException, InterruptedException {
			  driver= driverSetUp(browser,url);
	  }
		
	  @AfterClass
	  public void afterClass() throws InterruptedException {
		driver.quit();
	  }

}
