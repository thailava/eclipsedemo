package utility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Log {

	public static void startLog(Logger log) throws IOException
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		SimpleLayout layout = new SimpleLayout();
		String path = PropertyFileReader.loadFile().getProperty("log");
		FileAppender file = new FileAppender(layout, path + date.format(now)+".log", true);
		log.addAppender(file);
	}
	
	public static Logger logger(Class name)
	{
		Logger log = Logger.getLogger(name);
		return log;
		
	}
	
	public static void logInfo(Logger log, String message)
	{
		log.info(message);
	}
}
