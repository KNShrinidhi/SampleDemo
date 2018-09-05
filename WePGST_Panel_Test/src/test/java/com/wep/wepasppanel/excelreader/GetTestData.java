package com.wep.wepasppanel.excelreader;
//package com.wep.excelreader;
//
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//public class GetTestData {
//	
//	
//	public static Object[][] getdataFromDataSource(String InputFile, String SheetName, String TableName)
//	{
//		
//		//logger.info("Fetching Data from Excel File");
//		String[][] loginData = null;
//		try
//		{
//			Workbook workbook = Workbook.getWorkbook(new File(InputFile)); 
//			Sheet sheet = workbook.getSheet(SheetName);
//			
//			int startRow,startCol, endRow, endCol;
//			int ci = 0, cj;
//						
//			Cell tableStart=sheet.findCell(TableName);
//			
//			startRow=tableStart.getRow();
//			
//			startCol= tableStart.getColumn();
//			
//			
//			
//			Cell tableEnd= sheet.findCell(TableName, startCol+1,startRow+1, 200, 64000,  false);                
//			endRow=tableEnd.getRow();
//			
//			endCol = tableEnd.getColumn();
//			
//			loginData = new String[endRow-startRow-1][endCol-startCol-1];
//			
//			for (int i= startRow+1; i < endRow ; i++, ci++)
//			{	
//				cj = 0;				
//				for (int j= startCol+1; j <endCol; j++, cj++)
//				{
//					loginData[ci][cj] = sheet.getCell(j, i).getContents();
//				}	
//			}
//			
//		}
//		catch (FileNotFoundException ex)
//		{
//			ex.getMessage();
//			ex.printStackTrace();
//			System.out.println(ex);
//			//log.error("Ex:"+ex);
//		}
//		catch (Exception ex)
//		{
//			ex.getMessage();
//			System.out.println(ex);
//			//log.error("Ex:"+ex);
//			
//		}
//		
//		//logger.info("Returning Read Data From Excel File");
//		return loginData;
//		
//	}
//	
//	public static  Iterator<Object[]> getdataList(String InputFile, String SheetName, String TableName)
//	{		
//		
//		//logger.info("Fetching Data from Excel File");
//		List<Object[]> roleTestData = new ArrayList<Object[]>();
//		try
//		{
//						
//			Workbook workbook = Workbook.getWorkbook(new File(InputFile)); 
//			Sheet sheet = workbook.getSheet(SheetName);
//			
//			
//			int startRow,startCol, endRow, endCol;
//			int ci = 0, cj=0;
//			
//			Cell tableStart=sheet.findCell(TableName);
//			
//					
//			startRow=tableStart.getRow();			
//			startCol= tableStart.getColumn();
//			//startCol = startCol + 1;
//			
//			Cell tableEnd= sheet.findCell(TableName, startCol+1,startRow+1, 200, 64000,  false);               
//			endRow=tableEnd.getRow();
//			
//			endCol = tableEnd.getColumn();
//			
//			String temp = null;
//			List<String> tableData = new ArrayList<String>();
//			//loanData = new String[(endRow-startRow)+1][endCol];
//			//System.out.println(endCol-startCol-1);
//			
//			//UIConstants variable = new UIConstants();
//			
//			
//			for (int i= startRow+1; i <= endRow-1 ; i++, ci++)
//			{
//				
//				cj = 0;				
//				for (int j= startCol+1; j < endCol; j++, cj++)
//				{
//					temp = sheet.getCell(j, i).getContents();
//					tableData.add(temp.toString());
//				}	
//				roleTestData.add(new Object[] {tableData} );	
//				
//			}
//		}
//		
//		catch (FileNotFoundException ex)
//		{
//			ex.getMessage();
//			ex.printStackTrace();
//			System.out.println(ex);
//			//log.error("Ex:"+ex);
//		}
//		catch (Exception ex)
//		{
//			ex.getMessage();
//			System.out.println(ex);
//			//log.error("Ex:"+ex);
//			
//		}
//		//logger.info("Returning Read Data From Excel File");
//		
//		return roleTestData.iterator();
//		
//		
//	}
//	
//	public static void writeData(String InputFile, String SheetName, String TableName, String Result, String OutputFile)
//	{
//		int startRow,startCol, endRow, endCol;
//		Workbook workbook=null;
//		try{
//			File outputWorkbook = new File(OutputFile);
//			if(outputWorkbook.exists())
//			{
//				workbook = Workbook.getWorkbook(new File(OutputFile)); 
//			}
//			else
//			{
//				workbook = Workbook.getWorkbook(new File(InputFile)); 
//			}
//		
//		Sheet sheet = workbook.getSheet(SheetName);
//		Cell tableStart=sheet.findCell(TableName);
//		
//		
//		startRow=tableStart.getRow();			
//		startCol= tableStart.getColumn();
//		startCol = startCol + 1;
//		
//		
//		Cell tableEnd= sheet.findCell(TableName, startCol,startRow, 200, 64000,  false);                
//		endRow=tableEnd.getRow();
//		endRow=startRow + 1;
//		
//		
//		
//		endCol = tableEnd.getColumn();
//		//endCol = startCol + j	;
//		//j=j+2;
//		int noofcolumn=(endCol-startCol)+1;
//		
//		
//		
//		WritableWorkbook workbook1=Workbook.createWorkbook(outputWorkbook,workbook);
//        
//        WritableSheet sheet1 = workbook1.getSheet(SheetName);
//        
//               
//		Label label = new Label(noofcolumn,endRow,Result);
//		sheet1.addCell(label);
//		
//		workbook1.write();
//	    workbook1.close();
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//	}
//	
//}
//
