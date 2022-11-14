package com.udemy.testData;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, int excelSheetIndex) throws IOException {
		book = new XSSFWorkbook(excelPath);
		sheet = book.getSheetAt(excelSheetIndex);
	}

	public  int rowCount() throws IOException {
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
    public  int coloumnCount() throws IOException {
		
		int coloumnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		return coloumnCount;
	}
	
	public  String getCellDataString(int rowNum, int colNum) throws IOException {
		
		String stringcellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return stringcellData;
	}
	
    public  double getCellDataNum(int rowNum, int colNum) throws IOException {
		
		double numcellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return numcellData;
	}
    
 public  CellType getCellType(int rowNum, int colNum) throws IOException {
		
		CellType CellType=sheet.getRow(rowNum).getCell(colNum).getCellType();
		return CellType;
	}

}
