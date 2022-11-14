package com.udemy.testData;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;

public class ExcelDataProvider {
	 
	
	
	public  Object[][] testData(String excelPath, int excelSheetIndex) throws IOException {
		
		ExcelUtils exUt = new ExcelUtils(excelPath,excelSheetIndex);
		int colCount = exUt.coloumnCount();
		int rowCount = exUt.rowCount();
		String testData = null;
		Object data[][]=new Object[rowCount-1][colCount];
		
		CellType v = exUt.getCellType(0, 0);
		
		for(int i=1; i<rowCount; i++) {
			
			for (int j=0; j<colCount; j++) {
				
				CellType s=exUt.getCellType(i, j);
				
				if(s==v) {
					
					testData=exUt.getCellDataString(i,j);
			}
				else {
					double test=exUt.getCellDataNum(i,j);
					int num = (int)test;
					testData=String.valueOf(num);
				
				}
				data[i-1][j]=testData;
						}
		}
		return data;
	}

}
