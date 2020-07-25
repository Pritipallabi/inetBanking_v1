package com.inetBanking_testUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {
	
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook xw;
public static XSSFSheet xs;
public static XSSFRow row;
public static XSSFCell cell;

public static int getRowcount(String xlfile,String xlsheet) throws IOException {
	
	fi=new FileInputStream(xlfile);
	xw=new XSSFWorkbook(fi);
	xs=xw.getSheet(xlsheet);
	
	int rowcount=xs.getLastRowNum();
	xw.close();
	fi.close();
	return rowcount;
	
}
public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException {
	
	fi=new FileInputStream(xlfile);
	xw=new XSSFWorkbook(fi);
	xs=xw.getSheet(xlsheet);
	row=xs.getRow(rownum);
	int cellcount=row.getLastCellNum();
	xw.close();
	fi.close();
	return cellcount;
	
}
public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(xlfile);
	xw=new XSSFWorkbook(fi);
	xs=xw.getSheet(xlsheet);
	row=xs.getRow(rownum);
	cell=row.getCell(colnum);
	String data;
	try 
	{
		DataFormatter formatter = new DataFormatter();
        String cellData = formatter.formatCellValue(cell);
        return cellData;
	}
	catch (Exception e) 
	{
		data="";
	}
	xw.close();
	fi.close();
	return data;
}

public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
{
	fi=new FileInputStream(xlfile);
	xw=new XSSFWorkbook(fi);
	xs=xw.getSheet(xlsheet);
	row=xs.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	fo=new FileOutputStream(xlfile);
	xw.write(fo);		
	xw.close();
	fi.close();
	fo.close();
}



}
