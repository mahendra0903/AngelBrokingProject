 package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {
	static String NumValue;
    static String value;
	public static String getExcelData(int row,int cell) throws EncryptedDocumentException, IOException
	{

		String path = "C:\\Users\\DELL\\Desktop\\Software Testing\\testing.xlsx";
		FileInputStream file = new FileInputStream(path);
		Cell getcell = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell);
		try
		{
			String value= getcell.getStringCellValue();
			return value;
		}
		catch(Exception e)
		{
			double m =getcell.getNumericCellValue();
			long a = (long)m;
			String NumValue =String.valueOf(a);
			System.out.println(NumValue);
			return NumValue;
		}
	}
	
}