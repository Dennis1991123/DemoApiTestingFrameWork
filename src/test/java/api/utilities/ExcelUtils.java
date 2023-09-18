package api.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	FileInputStream ofile;
	XSSFWorkbook oWorkbook;
	XSSFSheet oSheet;
	XSSFRow oRow;
	XSSFCell oCell;
	
	public  ExcelUtils(String filename,String sheetname) throws Exception
	{
		ofile=new FileInputStream(filename);
		oWorkbook=new XSSFWorkbook(ofile);
		oSheet=oWorkbook.getSheet(sheetname);
	}
	
	public String getcellValue(int rowno,int columnno) throws Exception
	{
	
	oRow=oSheet.getRow(rowno);
	oCell=oRow.getCell(columnno);
	String CellValue=oCell.getStringCellValue();
	return CellValue;
	
	
	}
	public String getcellvalue(int rowNo,String colName) throws Exception {
		int colNo=0;
		oRow=oSheet.getRow(0);//first row content
		   for (int i=0; 1<oRow.getLastCellNum();i++) {
			   oCell=oRow.getCell(i);
		    if (oCell.getStringCellValue().equals(colName)) {
		    colNo=i;
		    break;
		    }
		   }
		     oRow = oSheet.getRow(rowNo);
		     oCell = oRow.getCell(colNo);
		   String value = oCell.getStringCellValue(); //to take string value
		   System.out.println("The value is :"+value);
		   oWorkbook.close();
		return value;
    
}
	
	public Object[][] getExcelDate() throws Exception {

		oRow=oSheet.getRow(0);
		int rows=oSheet.getLastRowNum();
		int cols=oRow.getLastCellNum();
		Object[][] exceldata=new Object[rows][cols];
		for (int i=1;i<=rows;i++) {
		for (int j=0;j<cols;j++) {
		exceldata[i-1][j]=this.getcellValue(i,j);

		}
		}

		return exceldata;
	}
	
}
