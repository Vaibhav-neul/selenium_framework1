package com.visionit.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldataprovider {
	File f;
	XSSFWorkbook wb;
	public exceldataprovider() throws Exception{
	    f = new File("C:\\Users\\Kaushtubh\\EclipseWorkspace\\selenium_framework1\\excelfile\\excel1.xlsx");
		FileInputStream fins=new FileInputStream(f);
		wb=new XSSFWorkbook(fins);
		}
	
	public String getstringcelldata(String sheetname,int row,int col){
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public int getnumericcelldata(String sheetname,int row,int col){
		return (int) wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public String getstringcelldata(int sheetno,int row,int col){
		return wb.getSheetAt(sheetno).getRow(row).getCell(col).getStringCellValue();
	}
	
	public int getnumericcelldata(int sheetno,int row,int col){
		return (int) wb.getSheetAt(sheetno).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public Object[][] exceltestdata(String sheetname){
		XSSFSheet sheet=wb.getSheet(sheetname);
		
		int rowcount=sheet.getLastRowNum();
		
		int colcount=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rowcount][colcount];
		
		for(int i=0;i<rowcount;i++){
			for(int j=0;j<colcount;j++){
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
		
		
	}
	
}
