package reusablecomponents;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.PropertyFileReader;

public class ReusableMethods {

	public static boolean click(WebDriver driver, By button) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(button).click();
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void loadurl(WebDriver driver)  {
		// TODO Auto-generated method stub
		try {
			driver.get(PropertyFileReader.loadFile().getProperty("url"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean findElement(WebDriver driver, By element) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(element);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static boolean sendKeys(WebDriver driver, By element, String msg) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(element).sendKeys(msg);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean sendKeys(WebDriver driver, By element, Keys keys) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(element).sendKeys(keys);
			return true;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean selectElement(WebDriver driver, By title, String text) {
		// TODO Auto-generated method stub
		try
		{
			WebElement element = driver.findElement(title);
			Select select = new Select(element);
			select.selectByVisibleText(text);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
