package Library;


import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig()
	{
	   try {
		    File source = new File("C:\\Users\\anaszulfiqar\\eclipse-workspace\\TestProject\\Testdata.xlsx");
		   
		    FileInputStream fls = new FileInputStream(source);
			
			 wb = new XSSFWorkbook(fls);
			
	       }
	   catch (Exception e) 
	       {
		
		     System.out.println(e.getMessage());
	       }
		
	}
	
	public String getData(int sheetNumber, int row, int column)
	{

		//index 0, 1, 2 means it will read the sheet1, sheet2, sheet3 respectively
		sheet1 = wb.getSheetAt(sheetNumber);
		
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getintData(int sheetNumber, int row, int column)
	{

		//index 0, 1, 2 means it will read the sheet1, sheet2, sheet3 respectively
		sheet1 = wb.getSheetAt(sheetNumber);
		
		int data = (int) sheet1.getRow(row).getCell(column).getNumericCellValue();
		return data;
	}

	public float getfloatData(int sheetNumber, int row, int column)
	{

		//index 0, 1, 2 means it will read the sheet1, sheet2, sheet3 respectively
		sheet1 = wb.getSheetAt(sheetNumber);
		
		float data = (float) sheet1.getRow(row).getCell(column).getNumericCellValue();
		return data;
	}

}
