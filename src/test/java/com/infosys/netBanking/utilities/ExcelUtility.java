package com.infosys.netBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	FileInputStream fis;
	XSSFWorkbook workbook; //--->xlsx format
	//HSSFWorkbook workbook1; //----> xls format
	XSSFSheet sheet;
	//HSSFSheet sheet1; //----> xls format
	
	//to open the excel sheet and to get the sheet 
	public void openExcel(String SheetName) {
			try {
			fis=new FileInputStream("C:\\Users\\Pranitha Regalla\\Desktop\\TestData.xlsx");
			workbook= new XSSFWorkbook(fis);
			sheet =workbook.getSheet(SheetName);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	//to get the data from the excel sheet
	public String getData(int row,int col) {
		if(sheet.getRow(row).getCell(col)!=null) {
			return sheet.getRow(row).getCell(col).toString();
		}
		else {
		
		return "";
		}
		 
	}
	
	public int getRowNum() {
		return sheet.getPhysicalNumberOfRows();
	}
	public int getcolumn(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	public void closeExcel()  {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="New Customer")
	public Object[][] getNewcustomerData() {
		
		ExcelUtility ec= new ExcelUtility();
		ec.openExcel("NewCustomer");
		   int totalRows=  ec.getRowNum();
		   int totalColum= ec.getcolumn(0);
		   Object[][] data= new Object[totalRows-1][totalColum];
		   for(int i=1;i<totalRows;i++) {
			   for(int j=0;j<totalColum;j++) {
				   data[i-1][j] = ec.getData(i, j);
				   
			   }
		   }
		
		return data;
		
	}
    
}
