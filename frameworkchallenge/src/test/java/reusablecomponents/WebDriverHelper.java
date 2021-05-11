package reusablecomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.PropertyFileReader;

public class WebDriverHelper {

	public static WebDriver startDriver(String data) throws IOException
	{
		if(data.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",PropertyFileReader.loadFile().getProperty("chromedriver"));
			WebDriver driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			return driver;
		}else if(data.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",PropertyFileReader.loadFile().getProperty("firefoxdriver"));
			WebDriver driver = new FirefoxDriver();
		
			driver.manage().window().maximize();
			return driver;
		}else
		{
			System.setProperty("webdriver.chrome.driver",PropertyFileReader.loadFile().getProperty("chromedriver"));
			WebDriver driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			return driver;
		}
		
	}

}
