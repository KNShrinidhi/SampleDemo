package com.wep.wepasppanel.dataproviders;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.excelreader.ExcelUtils;
import com.wep.wepasppanel.testcases.Browser_Initialization;

import org.testng.annotations.DataProvider;

public class DataProviderRepo extends Browser_Initialization
{
	public String FilePath=path+LoadConstantsData.readData(Constants.InputFilePath);
	public String OutPutFilePath=path+LoadConstantsData.readData(Constants.OutputFilePath);
	
	@DataProvider(name="ImportFiles")
	public Object[][] Import_Files() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UploadInformation_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Upload_CSV_File);
		Object[][] ImportFileDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return ImportFileDetails;
	}
	
	
	@DataProvider(name="GSTRSave")
	public Object[][] GSTR1_Save() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UploadInformation_Sheet);
		String TableName=LoadConstantsData.readData(Constants.GSTR1Save);
		Object[][] ImportFileDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return ImportFileDetails;
	}
	
	@DataProvider(name="GSTR1Download")
	public Object[][] GSTR1_Download() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.GSTRDownload_Sheet);
		String TableName=LoadConstantsData.readData(Constants.GSTR1DownloadTable);
		Object[][] ImportFileDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return ImportFileDetails;
	}
}
