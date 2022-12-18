package week7.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readdata(String fileName) throws IOException {
		//set the path
        XSSFWorkbook wbook=new XSSFWorkbook("Data/"+fileName+".xlsx");
        //Open the sheet
        XSSFSheet sheet = wbook.getSheetAt(0);
        
        //Row count
        
        int rowCount = sheet.getLastRowNum();
        
        //column count
        
        short columnCount = sheet.getRow(0).getLastCellNum();
        
        //data
        String [][] data=new String[rowCount][columnCount];
        
        //get row value using outer loop
        for(int i=1;i<=rowCount;i++)
        {
        	XSSFRow row = sheet.getRow(i);
        	//get column count using inner loop
        	for(int j=0;j<columnCount;j++)
        	{
        		XSSFCell cell = row.getCell(j);
        		System.out.println(cell.getStringCellValue());
        		data[i-1][j]=cell.getStringCellValue();
        	}
        }
      //close the workbook
        wbook.close();
      
        return data;
        
	}

}
