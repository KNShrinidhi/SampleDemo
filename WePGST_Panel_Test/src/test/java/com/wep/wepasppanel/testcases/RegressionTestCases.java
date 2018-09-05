package com.wep.wepasppanel.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wep.wepasppanel.dataproviders.DataProviderRepo;
import com.wep.wepasppanel.dataproviders.Dataproviders;
import com.wep.wepasppanel.pomclasses.GSTRUploads_GSTR1;
import com.wep.wepasppanel.pomclasses.GSTR_Downloads;
import com.wep.wepasppanel.pomclasses.Login_Page;
import com.wep.wepasppanel.pomclasses.UploadInformation_Page;

public class RegressionTestCases extends Browser_Initialization
{
	public SoftAssert softassert1= new SoftAssert();
	
	@Test(dataProvider="LoginDataProvider", dataProviderClass=Dataproviders.class)
	public void Login(String usr, String pwd,String Expected) throws Exception
	{
		Boolean res=new Login_Page(driver).Login(usr,pwd,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	@Test(dataProvider="ImportFiles", dataProviderClass=Dataproviders.class)
	public void Import_Files(String GSTR_Type,String Action, String File_path, String ExpectedResult) throws Exception
	{
		Boolean res= new UploadInformation_Page(driver).Import_CSV_File(GSTR_Type, Action, File_path);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	@Test(dataProvider="GSTRSave", dataProviderClass=DataProvider.class)
	public void GSTR1_Save(String Period,String GSTINNo, String GSTRType, String action, String Expected) 
	{
		Boolean res= new GSTRUploads_GSTR1(driver).GSTR1Save(Period, GSTINNo, GSTRType, action);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	@Test(dataProvider="GSTR1Download", dataProviderClass=DataProviderRepo.class)
	public void GSTR1Download(String GSTINNo,String Period, String Action, String ReferenceId, String Expected) 
	{
		Boolean res= new GSTR_Downloads(driver).GSTR1_Download(GSTINNo, Period, Action, ReferenceId);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	@Test
	public void logout()
	{
		Boolean res=new Login_Page(driver).logout();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
}
