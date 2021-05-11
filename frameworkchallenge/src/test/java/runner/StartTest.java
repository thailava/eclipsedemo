package runner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import reusablecomponents.WebDriverHelper;
import utility.ExcelReader;
import utility.ExtentReport;
import utility.Log;

public class StartTest {

	private static WebDriver driver;
	private static ExtentReports report = ExtentReport.generateReport();
	private static ExtentTest test;
	private static Logger log = Log.logger(StartTest.class);
	
	//@BeforeSuite
	@DataProvider(name = "data")
	public Object[][] beforeSuite(Method m) throws IOException
	{
		
		Object obj[][] = null;
		//Method m = null;
		if(m.getName().equals("beforeClass"))
		{
			obj = ExcelReader.excelReader("excel (1).xlsx","drivers");
			return obj;
		}
		
		return obj;
		
	}
	
	@Test(dataProvider = "data")
	public void beforeClass(String data) throws IOException
	{
		//System.out.println("in the test case");
		
		Log.startLog(log);
		driver = WebDriverHelper.startDriver("Chrome");
		test = report.startTest("driver loaded");
		ExtentReport.extentPass(test, data + "driver loaded successfully");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://www.abhibus.com/");
		//driver.findElement(By.id("datepicker1")).click();
		//String date ="11-06-2021";
		//HomePage.datePicker(driver, "ui-datepicker-div", date);
		
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("in after suite");
		//driver.quit();
		report.endTest(test);
		report.flush();
		report.close();
		//Email.email();
	}


	public static WebDriver getDriver() {
		return driver;
	}


	public static ExtentReports getReport() {
		return report;
	}


	


	public static Logger getLog() {
		return log;
	}
	

}
