package com.wep.wepasppanel.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.testcases.Browser_Initialization;

    /**
     * @author KK
     *
     */
    public class ExcelUtils extends Browser_Initialization{

			private static XSSFSheet ExcelWSheet;

			private static XSSFWorkbook ExcelWBook;

			private static XSSFCell Cell;
			
			/**
			 * Test case result file
			 */
			public String outputFilePath=path+LoadConstantsData.readData(Constants.OutputFilePath);

			@SuppressWarnings("unused")
			private static XSSFRow Row;

		/**
		 * @param FilePath
		 * @param SheetName
		 * @return
		 * @throws Exception
		 */
		//Method used read data from excel based on File and Sheet name
		public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

		   String[][] tabArray = null;

		   try {
			   
			   FileInputStream ExcelFile = new FileInputStream(FilePath);
			   
			   // Access the required test data sheet

			   ExcelWBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWBook.getSheet(SheetName);
			   
			   //System.out.println(SheetName);

			   int startRow = 1;

			   int startCol = 1;

			   int ci,cj;

			   int totalRows = ExcelWSheet.getLastRowNum();
			   
			   // you can write a function as well to get Column count
			   
			   int firstCol=ExcelWSheet.getRow(startRow).getFirstCellNum();
			   
			   int LastCol=ExcelWSheet.getRow(startRow).getLastCellNum();
			   
			   int totalCols = LastCol-firstCol;
			   
			    tabArray=new String[totalRows][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) 
			   {           	   

				  cj=0;

				   for (int j=startCol;j<=totalCols;j++, cj++)
				   {
					   tabArray[ci][cj]=getCellData(i,j);
					}

				}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}

		//Method used read data from excel based on File, Sheet name and Table name
		/**
		 * @param FilePath
		 * @param SheetName
		 * @param TableName
		 * @return
		 * @throws Exception
		 */
		public static Object[][] getTableArrayData(String FilePath, String SheetName, String TableName) throws Exception {   

			   String[][] tabArray = null;

			   try {
				   
				   FileInputStream ExcelFile = new FileInputStream(FilePath);
				   
				   // Access the required test data sheet

				   ExcelWBook = new XSSFWorkbook(ExcelFile);

				   ExcelWSheet = ExcelWBook.getSheet(SheetName);
				   
				   int ci=0,cj;
				   
				 
				   List<XSSFTable> tables = ExcelWSheet.getTables();
				  
				   for(int i=0; i<tables.size();i++)
				   {
					   
					   if(tables.get(i).getName().equalsIgnoreCase(TableName))
					   {
						   int startRow=tables.get(i).getStartCellReference().getRow();
						   int startCol=tables.get(i).getStartCellReference().getCol();
						   int endRow=tables.get(i).getEndCellReference().getRow();
						   int endCol= tables.get(i).getEndCellReference().getCol();


						    tabArray=new String[endRow-startRow-1][endCol-startCol-1];
						   
							   for (int k=startRow+1;k<=endRow-1;k++, ci++) 
							   {           	   
			
								  cj=0;
			
								   for (int j=startCol+1;j<=endCol-1;j++, cj++)
								   {
									   tabArray[ci][cj]=getCellData(k,j);
									  
									}
			
								}
					   }
				   }


					}

				catch (FileNotFoundException e){

					System.out.println("File Not Found");

					e.printStackTrace();

					}

				catch (IOException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}
			   	System.out.println(tabArray.length);
				return(tabArray);

				}
		
		//It will the cell value based on provided Row number and Col number
		/**
		 * @param RowNum
		 * @param ColNum
		 * @return
		 * @throws Exception
		 */
		@SuppressWarnings("deprecation")
		public static String getCellData(int RowNum, int ColNum) throws Exception {

			try{

				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				String CellData="";
				
				//int dataType = Cell.getCellType();

				if  (Cell==null)
				{

					return "";

				}
				else if(Cell.getCellType()==HSSFCell.CELL_TYPE_STRING)
				{

					CellData = Cell.getStringCellValue();

					return CellData;

				}
				else if(Cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC)
				{
					int value=(int) Cell.getNumericCellValue();
					CellData=String.valueOf(value);
					return CellData;
				}
			}
				catch (Exception e)
				{

				System.out.println(e.getMessage());

				throw (e);

				}
			return null;
			
			}
		
		//Method used write data to excel based on File, Sheet name and Column name
		/**
		 * @param FilePath
		 * @param SheetName
		 * @param TableName
		 * @param res
		 * @throws Exception
		 */
		@SuppressWarnings({ "static-access", "deprecation", "unused" })
		public static void writeExcelData(String FilePath, String SheetName, String TableName,Boolean res) throws Exception 
		{
			try {
				
						
				   
				
				FileInputStream ExcelFile = new FileInputStream(FilePath);
				   
				   // Access the required test data sheet

				   ExcelWBook = new XSSFWorkbook(ExcelFile);

				   ExcelWSheet = ExcelWBook.getSheet(SheetName);
				   
				   int ci=0;
				 
				   //System.out.println(SheetName);
				   List<XSSFTable> tables = ExcelWSheet.getTables();
				  
				   for(int i=0; i<tables.size();i++)
				   {
					  if(tables.get(i).getName().equalsIgnoreCase(TableName))
					   {
						  int startRow=tables.get(i).getStartCellReference().getRow();
						  int endRow=tables.get(i).getEndCellReference().getRow();
						   int endCol= tables.get(i).getEndCellReference().getCol();
						   
						   	for (int k=startRow+1;k<=endRow-1;k++, ci++) 
							{           	   
					    		Row=ExcelWSheet.getRow(k) ;
					    		XSSFCell resultCell=Row.getCell(endCol)	;
					    		
					    		if(resultCell==null)
					    		{
					    			resultCell=Row.createCell(endCol);
					    		}
					    		resultCell.setCellType(Cell.CELL_TYPE_STRING);
					    		resultCell.setCellValue(res.toString());
					    	}
					   }
				   }
			}
				   catch (FileNotFoundException e){

						System.out.println("File Not Found");

						e.printStackTrace();

						}

					catch (IOException e){

						System.out.println("Could not read the Excel sheet");

						e.printStackTrace();

						}
		}
		
		//Method used write data to cell based on provided result, row num and col num
		/**
		 * @param Result
		 * @param RowNum
		 * @param ColNum
		 * @return
		 * @throws Exception
		 */
		@SuppressWarnings({ "deprecation", "static-access" })
		public static Boolean setCellData(Boolean Result,  int RowNum, int ColNum) throws Exception	{
			 
   			try{
   				  				
   				System.out.println(RowNum);
   				System.out.println(ColNum);
   				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      			//System.out.println(Cell.CELL_TYPE_BLANK);
   				if(Cell.CELL_TYPE_BLANK==HSSFCell.CELL_TYPE_BLANK)
   				{
   					//Cell = Row.createCell(ColNum);
   					Cell.setCellValue(Result.toString());
   					return true;
   				}
   				else
   				{
   					return false;
   				}

//				Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
//
//				if (Cell == null) {
//
//					Cell = Row.createCell(ColNum);
//
//					Cell.setCellValue(Result);
//
//					} else {
//
//						Cell.setCellValue(Result);
//
//					}

      // Constant variables Test Data path and Test Data file name

      				

					}catch(Exception e){

						throw (e);

				}

			}
		
		//Method used write data to excel based on File, Sheet name and Column name
				/**
				 * @param FilePath
				 * @param SheetName
				 * @param TableName
				 * @param res
				 * @param OutputFilePath
				 * @throws Exception
				 */
				@SuppressWarnings({ "unused", "static-access", "deprecation" })
				public static void writeExcelDataRevised(String FilePath, String SheetName, String TableName,Boolean res, String OutputFilePath) throws Exception 
				{
					try {
//						XSSFWorkbook workbook=null;						
//						File outputWorkbook = new File(OutputFilePath);
//						if(outputWorkbook.exists())							{
//								workbook = XSSFWorkbook.getWorkbook(new File(OutputFilePath)); 
//						}							else
//							{
//								workbook = XSSFWorkbook.getWorkbook(new File(FilePath)); 
//							}
						   
							FileInputStream ExcelFile = new FileInputStream(FilePath);
						   
						   // Access the required test data sheet

						   ExcelWBook = new XSSFWorkbook(ExcelFile);

						   ExcelWSheet = ExcelWBook.getSheet(SheetName);
						   
						   int ci=0,cj;
						   
						   //System.out.println(SheetName);
						   List<XSSFTable> tables = ExcelWSheet.getTables();
						  
						   for(int i=0; i<tables.size();i++)
						   {
							  if(tables.get(i).getName().equalsIgnoreCase(TableName))
							   {
								  int startRow=tables.get(i).getStartCellReference().getRow();
//								   int startCol=tables.get(i).getStartCellReference().getCol();
								   int endRow=tables.get(i).getEndCellReference().getRow();
								   int endCol= tables.get(i).getEndCellReference().getCol();
								   
								   							   
							    	for (int k=startRow+1;k<=endRow-1;k++, ci++) 
									{           	   
//							    		Boolean result=setCellData(res,k,endCol);
//										if(result)
//										{
//											//FileUtils.copyFile(File FilePath, File outputFilePath)
//											System.exit(0);
//										}
							    		
							    		Row=ExcelWSheet.getRow(k) ;
							    		XSSFCell resultCell=Row.getCell(endCol)	;
							    		
							    								    		
							    			if(resultCell==null)
								    		{
								    			resultCell=Row.createCell(endCol);
								    			
								    		}
							    			if(resultCell.getCellType()==HSSFCell.CELL_TYPE_BLANK && resultCell.getStringCellValue().isEmpty())
							    			{
//							    				System.out.println("Has Data");
//							    				String cellValue=resultCell.getStringCellValue();
//							    				if(cellValue!=null)
//							    				{
//							    					resultCell.setCellType(Cell.CELL_TYPE_STRING);
//										    		resultCell.setCellValue(res.toString());
//							    				}
							    				System.out.println("Result Value : "+res);
							    				resultCell.setCellType(Cell.CELL_TYPE_STRING);
									    		resultCell.setCellValue(res.toString());
									    		
							    			}
								    		
							    		}
								    		
							    		
							    	}
							   }
						   FileOutputStream outFile =new FileOutputStream(new File(FilePath));
						   ExcelWBook.write(outFile);
						   outFile.close();
						   						   
						 
					}
						   catch (FileNotFoundException e){

								System.out.println("File Not Found");

								e.printStackTrace();

								}

							catch (IOException e){

								System.out.println("Could not read the Excel sheet");

								e.printStackTrace();

								}
				}
				
				
	}

	