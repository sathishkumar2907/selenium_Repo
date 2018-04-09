package com.tvisha.xcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public String filepath;
    public String sheetname;
    public FileInputStream fis = null;
    private static Workbook workbook = null;
	private static Sheet sheet = null;
	private static Row row = null;
	private static Cell cell = null;
	public static Hashtable<String, String> hastable;

    public Excel(String path) throws IOException{
    	//this.filepath=path;
    	fis=new FileInputStream(path);
    	workbook = new XSSFWorkbook(fis);
    }
    
    public static Object[][] hashtable_data(String sheet_name,String TCID,String Runmode){
	Object[][] obj=null;
    	
	
    sheet=workbook.getSheet(sheet_name);
	int row_count=sheet.getLastRowNum()+1;
    System.out.println("row_count==>"+row_count);	
    
    int colo=sheet.getRow(0).getLastCellNum();
    System.out.println("colo_count==>"+colo);
    
    obj=new Object[row_count-1][1];
    
    for(int i=1;i<row_count;i++){
    	hastable=new Hashtable<String,String>();
    	hastable.put("SheetName", sheet_name);
    	for(int j=0;j<colo;j++){
    		hastable.put(sheet.getRow(0).getCell(j).getStringCellValue(), String.valueOf(sheet.getRow(i).getCell(j).getStringCellValue()));
    		System.out.println("key==> "+sheet.getRow(0).getCell(j).getStringCellValue() + " Value===>"+ sheet.getRow(i).getCell(j).getStringCellValue());
    		int r=i-1;
    		obj[r][0]=hastable;
    		System.out.println("data["+r+"]["+0+"]===>"+obj[r][0]);
    		//System.out.println(obj[i-1][0]);
    	}
      }
     return obj;
    }
  }
