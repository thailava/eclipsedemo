package utility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	public static String name;
	public static ExtentReports generateReport() 
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		try {
			name = PropertyFileReader.loadFile().getProperty("reports") + date.format(now)+".html";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentReports report = new ExtentReports(name);
		
		return report;	
	}
	
	public static String getFile()
	{
		return name;
	}
	
	public static void extentPass(ExtentTest test, String message)
	{
		test.log(LogStatus.PASS, message);
	}

	public static void extentFail(ExtentTest test, String message) {
		// TODO Auto-generated method stub
		test.log(LogStatus.FAIL, message);
	}
}
