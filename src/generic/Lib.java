package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Lib implements IAutoConstant
{
	public static Workbook wb;
	public static String getcellValue(String EXCEL_PATH,String sheet,int row,int column)
	{
		String cellvalue="";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellvalue = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e) 
		{}
		return cellvalue;	
	}
	
	public static int getRowCount(String EXCEL_PATH,String sheet)
	{
		int rowCount=0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) 
		{}
		return rowCount;
	}
	
	public static String getPropertyValue(String Key)
	{
		String PropertyValue="";
		Properties prop=new Properties();
		try 
		{
			prop.load(new FileInputStream(CONFIG_PATH));
			PropertyValue = prop.getProperty(Key);
		} catch (Exception e) 
		{
		}
		return PropertyValue;
	}
	public static void captureScreenshot(WebDriver driver, String testcaseName)
	{
		try
		{
		Date d = new Date();
		String currentDate = d.toString().replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/"+testcaseName+"_"+currentDate+".png");
		FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e){}
	}
}
