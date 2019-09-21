package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDriven {
	//name of the DataProvider is empLogin
	@DataProvider(name = "zbLogin")
	public static Object[][] readExcel() throws IOException {
		Object[][] arrayObject;

		//public static String readExcel() throws IOException {
		//specify the excel file containing test data
		File src=new File("C:\\DataDrivenTestNew\\testdata.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook getSheetAt(0) gets the first sheet
		XSSFSheet sheet=wb.getSheetAt(0);
		//To get the used row count use getLastRowNum() and add 1 since it returns row index which starts from 0
		int rowCount = sheet.getLastRowNum()+1;
		System.out.println(rowCount);
		//To get used column count use row's getLastCellNum(). 1 is not added as columns start from 1.
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(colCount);
		//Create a 2d Array that holds all the values in excel in a 2d array with rowcount and colcount as rows and columns.
		String [] [] data = new String[rowCount][colCount];
		int j;
		//To avoid the row and column names start the iteration from 1
		for(int i = 0;i<rowCount; i++) {
			for(j=0;j<colCount;j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(data[i][j]);
			}
		}
		arrayObject = data;
		return arrayObject;
	}


	public static void writeIntoExcel() throws IOException {

		File file =    new File("C:\\DataDrivenTestNew\\testdata.xlsx");
		String dataToBeAdded[]= {"Test","paswd"};
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=sheet.getLastRowNum()+1;
		int colCount=sheet.getRow(0).getLastCellNum();
		Row newRow = sheet.createRow(rowCount+1);
		for(int j=0;j<colCount;j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToBeAdded[j]);
		}

		FileOutputStream outputStream = new FileOutputStream(file);
		wb.write(outputStream);
		outputStream.close();
		wb.close();
	}
}


