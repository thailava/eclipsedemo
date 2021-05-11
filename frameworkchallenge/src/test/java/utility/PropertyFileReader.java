package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public static Properties loadFile() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream input = new FileInputStream(".\\src\\test\\resources\\config.properties");
		properties.load(input);
		
		return properties;
		//System.out.println(properties.getProperty("url"));
	}
}
