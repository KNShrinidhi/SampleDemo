package com.wep.wepasppanel.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.dataproviders.Dataproviders;
import com.wep.wepasppanel.pomclasses.Add_GSTIN_Page;
import com.wep.wepasppanel.pomclasses.Add_PAN_Page;
import com.wep.wepasppanel.pomclasses.CustomerManagement;
import com.wep.wepasppanel.pomclasses.GSTRUploads_GSTR1;
import com.wep.wepasppanel.pomclasses.GSTR_Downloads;
import com.wep.wepasppanel.pomclasses.Login_Page;
import com.wep.wepasppanel.pomclasses.SupplierManagement;
import com.wep.wepasppanel.pomclasses.UploadInformation_Page;

public class SmokeTestCases extends Browser_Initialization
{
	/**
	 * @param usr
	 * @param pwd
	 * @throws Exception
	 */
	@Test(dataProvider="LoginDataProvider", dataProviderClass=Dataproviders.class , priority=1)
	public void Login(String usr, String pwd,String Expected) throws Exception
	{
	
		Boolean res=new Login_Page(driver).Login(usr,pwd,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	

	//@Test(dataProvider="AddPANNumber", dataProviderClass=Dataproviders.class, priority=2)
	/**
	 * @param PANNo
	 * @param CompanyName
	 * @param PANDoc
	 * @param GSTNDoc
	 * @param POADoc
	 * @throws Exception
	 */
	public void Add_PAN_Details(String PANNo, String CompanyName,String PANDoc, String GSTNDoc, String POADoc,String Expected) throws Exception
	{
		Boolean res=new Add_PAN_Page(driver).addPANNumber(PANNo, CompanyName,PANDoc,GSTNDoc,POADoc,Expected);
		//ExcelUtils.writeExcelDataRevised(path+LoadConstantsData.readData(Constants.InputFilePath), LoadConstantsData.readData(Constants.PANSheet), LoadConstantsData.readData(Constants.AddPANDeatils), res,path+LoadConstantsData.readData(Constants.OutputFilePath));
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();

	}
	
	//@Test(dataProvider="EditPANNumber", dataProviderClass=Dataproviders.class, priority=5)
	/**
	 * @param PANToBeEdited
	 * @param PANNumber
	 * @param CompanyName
	 * @param PANDoc
	 * @param GSTNDoc
	 * @param POADoc
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void Edit_PAN_Details(String PANToBeEdited, String PANNumber, String CompanyName,String PANDoc, String GSTNDoc, String POADoc,String Expected) throws IOException, InterruptedException
	{
		Boolean res=new Add_PAN_Page(driver).editPANNumber(PANToBeEdited,PANNumber, CompanyName,PANDoc,GSTNDoc,POADoc,Expected);
		//GetTestData.writeData(path+LoadConstantsData.readData(Constants.InputFilePath), LoadConstantsData.readData(Constants.LoginSheet), LoadConstantsData.readData(Constants.LoginTable), res.toString(), path+LoadConstantsData.readData(Constants.OutputFilePath));
		
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
		
	}
	
	//@Test(dataProvider="DeletePANNumber", dataProviderClass=Dataproviders.class, priority=7)
	/**
	 * @param PANToBeEdited
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void Delete_PAN_Details(String PANToBeEdited, String Expected) throws IOException, InterruptedException
	{
			Boolean res=new Add_PAN_Page(driver).delete_PAN_Details(PANToBeEdited);
			//GetTestData.writeData(path+LoadConstantsData.readData(Constants.InputFilePath), LoadConstantsData.readData(Constants.LoginSheet), LoadConstantsData.readData(Constants.LoginTable), res.toString(), path+LoadConstantsData.readData(Constants.OutputFilePath));
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}
	
	//@Test(dataProvider="AddGSTN", dataProviderClass=Dataproviders.class , priority=3)
	/**
	 * @param GSTNUsername
	 * @param GSTNNo
	 * @param GSTNAddress
	 * @throws InterruptedException
	 */
	public void Add_GSTN(String GSTNUsername, String GSTNNo, String GSTNAddress,String Expected) throws InterruptedException
	{
		Boolean res= new Add_GSTIN_Page(driver).Add_GSTN(GSTNUsername, GSTNNo, GSTNAddress,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
		
	}
	
	//@Test(dataProvider="EditGSTN", dataProviderClass=Dataproviders.class, priority=4)
	/**
	 * @param GSTN_To_Be_Edited
	 * @param GSTNUsername
	 * @param GSTNNo
	 * @param GSTNAddress
	 * @throws InterruptedException
	 */
	public void Edit_GSTN(String GSTN_To_Be_Edited, String GSTNUsername, String GSTNNo, String GSTNAddress,String Expected) throws InterruptedException
	{
		Boolean res= new Add_GSTIN_Page(driver).edit_GSTN_Details(GSTN_To_Be_Edited, GSTNUsername, GSTNNo, GSTNAddress,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	//@Test(dataProvider="DeleteGSTN", dataProviderClass=Dataproviders.class, priority=6)
	/**
	 * @param GSTN_To_Be_Edited
	 * @throws InterruptedException
	 */
	public void Delete_GSTN(String GSTN_To_Be_Edited, String ExpectedResult) throws InterruptedException
	{
		Boolean res= new Add_GSTIN_Page(driver).delete_GSTN_Details(GSTN_To_Be_Edited);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	
	//@Test(dataProvider="CustomerDetails", dataProviderClass=Dataproviders.class, priority=8)
	public void Customer_Company_Details(String CName, String email, String MobileNo, String GSTIN, String State, String PancardNumber,  String ConstitutionBusiness, String Nature_of_Business, String ContactPerson,
					 String address,String Expected) throws  Exception
	{
		Boolean res= new CustomerManagement(driver).Add_CompanyDetails(CName, email, MobileNo, GSTIN,State,PancardNumber,ConstitutionBusiness,Nature_of_Business,ContactPerson,address,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
		
	//@Test(dataProvider="EditCustomerDetails", dataProviderClass=Dataproviders.class, priority=9)
	public void EditCustomerDetails(String CName, String Nature_of_Business, String ConstitutionBusiness, String Address, String DOR,String contactPerson, String Expected) throws  Exception
	{
				Boolean res= new CustomerManagement(driver).EditCustomerDetails(CName, Nature_of_Business,ConstitutionBusiness,Address, DOR, contactPerson,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
	
	//@Test(dataProvider="DeleteCustomerDetails", dataProviderClass=Dataproviders.class, priority=10)
	public void DeleteCustomerDetails(String CName, String Expected) throws  Exception
	{
				Boolean res= new CustomerManagement(driver).DeleteCustomerDetails(CName);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
	
			/**@(priority=15)
			 * @calling DataProvider SupplierDetails		
			 * @param CName
			 * @param email
			 * @param MobileNo
			 * @param GSTIN
			 * @param ConstitutionBusiness
			 * @param Nature_of_Business
			 * @param ContactPerson
			 * @param address
			 * @throws Exception
			 * @Calling Method:Add_SupplierDetails from SupplierManagement Class
			 */
					
	//@Test(dataProvider="SupplierDetails", dataProviderClass=Dataproviders.class, priority=11)
	public void Supplier_Company_Details(String CName, String email, String MobileNo, String GSTIN,String state,String pancard, String ConstitutionBusiness, String Nature_of_Business, String ContactPerson,
				 String address,String Expected) throws  Exception
	{
				Boolean res= new SupplierManagement(driver).Add_SupplierDetails(CName, email, MobileNo, GSTIN, state, pancard, ConstitutionBusiness, Nature_of_Business, ContactPerson, address,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
		
	//@Test(dataProvider="EditSupplierDetails", dataProviderClass=Dataproviders.class, priority=12)
	public void EditSupplierDetails(String CName, String ConstitutionBusiness, String Nature_of_Business, String ContactPerson, String address,String DOR,String Expected) throws  Exception
	{
				Boolean res= new SupplierManagement(driver).EditSupplierDetails(CName, Nature_of_Business, ConstitutionBusiness, address,DOR, ContactPerson,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
	
	//@Test(dataProvider="DeleteSupplierDetails", dataProviderClass=Dataproviders.class, priority=13)
	public void DeleteSupplierDetails(String CName, String Expected) throws  Exception
	{
				Boolean res= new SupplierManagement(driver).DeleteSupplierDetails(CName);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
	
	//@Test(dataProvider="ImportFiles", dataProviderClass=Dataproviders.class, priority=13)
	/**
	 * @param GSTR_Type
	 * @param Action
	 * @param File_path
	 * @throws Exception 
	 */
	public void Import_Files(String GSTR_Type,String Action, String File_Name, String ExpectedResult) throws Exception
	{
		String File_path=path+LoadConstantsData.readData(Constants.CSVfilesPath)+File_Name;
		System.out.println(File_path);
		Boolean res= new UploadInformation_Page(driver).Import_CSV_File(GSTR_Type, Action, File_path);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	//@Test(dataProvider="GSTRSave", dataProviderClass=Dataproviders.class, priority=14)
	public void GSTR1_Save(String Period,String GSTINNo, String GSTRType, String action, String Expected) 
	{
		Boolean res= new GSTRUploads_GSTR1(driver).GSTR1Save(Period, GSTINNo, GSTRType, action);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	@Test(dataProvider="GSTR1Download", dataProviderClass=Dataproviders.class, priority=15)
	public void GSTR1Download(String GSTINNo,String Period, String Action, String ReferenceId, String Expected) 
	{
		Boolean res= new GSTR_Downloads(driver).GSTR1_Download(GSTINNo, Period, Action, ReferenceId);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	@Test(priority=16)
	public void logout()
	{
		Boolean res=new Login_Page(driver).logout();
		System.out.println(res);
	}
}
