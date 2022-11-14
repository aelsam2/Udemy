package com.udemy.base;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFunction {
	Wait wait;
    FluentWait<WebDriver> fluentWait;
	
	public void Click(WebDriver driver,WebElement element, int timeout)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
	
	public void SendKeys(WebDriver driver,WebElement element, int timeout, String value)
	{
	   fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		
	   fluentWait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	
	public void SendKeysWithEnter(WebDriver driver,WebElement element, int timeout, String value)
	{
	   fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		
	   fluentWait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
		
	}
	
	public String GetText( WebDriver driver,WebElement element, int timeout)
	{
	   fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		
	   fluentWait.until(ExpectedConditions.visibilityOf(element));
		String Text=element.getText();
		return Text;
		
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver WaitUntilElementVisible ( WebDriver driver,WebElement element,int timeout) {
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofMillis(100))
	            .ignoring(WebDriverException.class);
		
	   fluentWait.until(ExpectedConditions.visibilityOf(element));
		return driver;
	}


}
