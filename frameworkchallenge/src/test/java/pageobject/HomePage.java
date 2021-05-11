package pageobject;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusablecomponents.ReusableMethods;
import utility.Log;

public class HomePage {

	public static boolean enterSourceLocation(WebDriver driver, By element, Logger log, String location)
	{
			if(ReusableMethods.findElement(driver, element))
			{
				Log.logInfo(log, "From search box found");
				if(ReusableMethods.sendKeys(driver, element, location))
				{
					//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					System.out.println("sss");
					if(ReusableMethods.sendKeys(driver, element, Keys.ENTER))
					{
						new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
						
						Log.logInfo(log, "the" + location + "is entered in from search box");
						return true;
					}
				}
			
			
		}
		return false;
	}
	
	public static boolean enterToLocation(WebDriver driver, By element, Logger log, String location)
	{
		if(ReusableMethods.findElement(driver, element))
		{
			Log.logInfo(log, "to search box found");
			if(ReusableMethods.sendKeys(driver, element, location))
			{
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				if(ReusableMethods.sendKeys(driver, element, Keys.ENTER))
				{
					Log.logInfo(log, "the" + location + "is entered in to search box");
					return true;
				}
			}
		}
		return false;
	}
	public static boolean selectDate(WebDriver driver, String date, By element , Logger log)
	{
		if(ReusableMethods.click(driver, element))
		{
			Log.logInfo(log, "clicked on on ward journey date button");
			datePicker(driver, date);
			Log.logInfo(log, "date selected as " + date);
			
		}
		return false;
	}
	public static void datePicker(WebDriver driver, String date)
	{
		//JavascriptExecutor je=(JavascriptExecutor)driver;
	    //je.executeScript("document.getElementById('"+datePickerId+"').value = '"+date+"';");
	    JavascriptExecutor je=(JavascriptExecutor)driver;
	    je.executeScript("document.getElementById('datepicker1').value = '"+date+"';");
	}
	
	public static boolean search(WebDriver driver, Logger log, By element)
	{
		if(ReusableMethods.click(driver, element))
		{
			Log.logInfo(log, "clicked on search button");
			return true;
		}
		return false;
	}
}
