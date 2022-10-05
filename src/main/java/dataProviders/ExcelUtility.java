package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static XSSFWorkbook wb;
	
	public static Workbook wr;
	
	public static Object[][] getDataFromSheet(String sheetName)
	{
		System.out.println("*********** Loading Excel Data ****************");
		
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/TestData1.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println("File not found "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Something went wrong "+e.getMessage());
			
		}
		
		XSSFSheet sh1=wb.getSheet(sheetName);
		
		int row=sh1.getPhysicalNumberOfRows();
		
		int colum=sh1.getRow(0).getPhysicalNumberOfCells();
	
		
		Object [][] arr=new Object[row][colum];
		
		for (int i=0;i<row;i++)
		{
			for(int j=0;j<colum;j++)
			{
				arr[i][j]=getDataUsingDataFormatter(sheetName, i, j);
			}
		}
			return arr;		
	}
	
	public static Object[][] getDataFromSheet2(String sheetName)
	{
		System.out.println("*********** Loading Excel Data ****************");
		
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println("File not found "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Something went wrong "+e.getMessage());
			
		}
		
		XSSFSheet sh1=wb.getSheet(sheetName);
		
		int row=sh1.getPhysicalNumberOfRows();
		
		int colum=sh1.getRow(0).getPhysicalNumberOfCells();
	
		
		Object [][] arr=new Object[row][colum];
		
		for (int i=0;i<row;i++)
		{
			for(int j=0;j<colum;j++)
			{
				arr[i][j]=getDataUsingDataFormatter(sheetName, i, j);
			}
		}
			return arr;		
	}

	public static String getDataUsingDataFormatter(String sheetName,int row,int column)
	{
		
		 DataFormatter df=new DataFormatter();
	     
		 String data=df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(column));
		 
		 return data;
	}

	
	
	

	public static String getData(String sheetName, int row, int column)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		String data="";
		if (cell.getCellType()==CellType.STRING) 
		{
			data=cell.getStringCellValue();
		}
		else if (cell.getCellType()==CellType.NUMERIC)
		{
			double dataInDouble=cell.getNumericCellValue();
			data=String.valueOf(dataInDouble);
		}
		else if (cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
	
	

}
