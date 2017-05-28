package test.propertyfinder;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


    public class ReadDataFromFile {
	
      private static XSSFWorkbook wb;
      
      protected static ArrayList<String> readExcelDataFile(int colNo) throws FileNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("/Users/antanina/Documents/TestData.xlsx");
		wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		Iterator<Row> rowIt=sheet.iterator() ;
		rowIt.next();
		 
		ArrayList<String> list = new ArrayList<String>();
		 
		 while (rowIt.hasNext()){
			 
	     list.add(rowIt.next().getCell(colNo).getStringCellValue());
			 
		 }
		
		 return list;
	   }
	  public ArrayList<String> readExcelData(int colNo) throws IOException{
			 
			return readExcelDataFile(colNo);
				 
			 }
			 
	
}