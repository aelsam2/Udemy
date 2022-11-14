package com.udemy.testData;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestData {
	ExcelDataProvider dP =new ExcelDataProvider();
	String projPath =System.getProperty("user.dir");
	
@DataProvider(name="AddCourseToWishListBySeachingtheCourse")
	  public Object[][] TC001Data() throws IOException {
		  String excelPath=projPath+"\\DataSheet\\Data.xlsx";
		  int excelSheetIndex=0;
		  Object data[][]=dP.testData(excelPath,excelSheetIndex);	  
		  return data;
	  }

}
