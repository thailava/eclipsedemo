package runner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageobject.HomePage;
import pageobject.SearchResultsPage;
import reusablecomponents.ReusableMethods;
import uistore.HomePageUI;
import uistore.SearchResultsPageUI;
import utility.ExtentReport;
import utility.Log;
import utility.PropertyFileReader;
import utility.TakeSS;

public class FirstTest {

	private WebDriver driver;
	private ExtentReports report;
	private ExtentTest test;
	private Logger log;
	
	@BeforeClass
	public void beforeClass()
	{
		driver = StartTest.getDriver();
		report = StartTest.getReport();
		//test = StartTest.getTest();
		test = report.startTest("first test");
		log = StartTest.getLog();
	}
	@Test(priority = 1)
	public void loadSite()
	{
		ReusableMethods.loadurl(driver);
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ExtentReport.extentPass(test, "site LOaded");
		
	}
	
	@Test(priority = 2)
	public void enterFromLoc() throws IOException
	{
		String location = PropertyFileReader.loadFile().getProperty("source");
		boolean result = HomePage.enterSourceLocation(driver, HomePageUI.source, log, location);
		Assert.assertEquals(result, true);
		Log.logInfo(log, "From location entered successfully as" + location );
		ExtentReport.extentPass(test, "From location entered successfully as" + location);
	}
	
	@Test(priority = 3)
	public void enterToLoc() throws IOException
	{
		String location = PropertyFileReader.loadFile().getProperty("destination");
		boolean result = HomePage.enterToLocation(driver, HomePageUI.dest, log, location);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(result, true);
		Log.logInfo(log, "destination location entered successfully as" + location);
		ExtentReport.extentPass(test, "destination location entered successfully as" + location);
	}
	
	@Test(priority = 4)
	public void selectJourneyDate() throws IOException
	{
		//driver.findElement(By.id("datepicker1")).click();
		String date = PropertyFileReader.loadFile().getProperty("date");
		//String date ="11-06-2021";
		HomePage.datePicker(driver, date);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePage.search(driver, log, HomePageUI.search);
		Log.logInfo(log, "selected a product");
		ExtentReport.extentPass(test, "selected a product");
	}
	
	@Test(priority = 5)
	public void searchResults()
	{
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SearchResultsPage.hoverOnBus(driver, log, SearchResultsPageUI.busSelected);
		SearchResultsPage.showSeatLayout(driver, log, SearchResultsPageUI.selectSeats);
		SearchResultsPage.selectSeat(driver, log, SearchResultsPageUI.seat);
		SearchResultsPage.selectBoardingPoint(driver, log, SearchResultsPageUI.boardingPoint);
		SearchResultsPage.nextPage(driver, log, SearchResultsPageUI.nextPage);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
	   if (result.getStatus() == ITestResult.FAILURE) {
		   ExtentReport.extentFail(test, test.addScreenCapture(TakeSS.ss(driver)));
	   }
	   report.endTest(test);
	}
}
