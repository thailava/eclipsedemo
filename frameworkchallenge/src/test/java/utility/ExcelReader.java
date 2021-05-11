package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] excelReader(String filename, String sheetName) throws IOException
	{
		//System.out.println("in excel utility");
		Object obj[][]  = null;
		File file = new File(".//" + filename);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet s = wb.getSheet(sheetName);
		int rowCount = s.getLastRowNum()-s.getFirstRowNum();
		Row row = s.getRow(0);
		
		obj = new Object[rowCount+1][row.getLastCellNum()];
		//System.out.println(rowCount);
		for(int i = 0; i <= rowCount; i++)
		{
			row = s.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++)
			{
				//System.out.println(row.getLastCellNum());
				obj[i][j] = row.getCell(j).getStringCellValue();
				//System.out.println(obj[i][j]);
				//System.out.println("in the loop");
			}
			
		}
		
	//	wb.close();
		return obj;
	}

}
