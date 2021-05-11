package pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import reusablecomponents.ReusableMethods;

public class SearchResultsPage {

	public static boolean hoverOnBus(WebDriver driver, Logger log, By element)
	{
		if(ReusableMethods.findElement(driver, element))
		{
			Actions actions = new Actions(driver);
			WebElement ele = driver.findElement(element);
			actions.moveToElement(ele).perform();
			return true;
		}
		return false;
		
	}
	
	public static boolean showSeatLayout(WebDriver driver, Logger log, By element)
	{
		if(ReusableMethods.click(driver, element))
		{
			return true;
		}return false;
	}
	
	public static boolean selectSeat(WebDriver driver, Logger log, By element)
	{
		if(ReusableMethods.click(driver, element))
		{
			return true;
		}return false;
	}
	
	public static boolean nextPage(WebDriver driver, Logger log, By element)
	{
		if(ReusableMethods.click(driver, element))
		{
			return true;
		}return false;
	}
	
	public static boolean selectBoardingPoint(WebDriver driver, Logger log, By element)
	{
		if(ReusableMethods.click(driver, element))
		{
			Select select = new Select(driver.findElement(element));
			select.selectByIndex(0);
			return true;
			
		}return false;
	}
}
