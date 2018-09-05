package com.wep.wepasppanel.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.dataproviders.*;
import com.wep.wepasppanel.excelreader.ExcelUtils;
import com.wep.wepasppanel.pomclasses.Add_GSTIN_Page;
import com.wep.wepasppanel.pomclasses.Login_Page;
import com.wep.wepasppanel.pomclasses.NiLRateInvoices_Page;
import com.wep.wepasppanel.pomclasses.Outward_Register_Page;
import com.wep.wepasppanel.pomclasses.Report_Page;
import com.wep.wepasppanel.pomclasses.Reports;
import com.wep.wepasppanel.pomclasses.SupplierManagement;
import com.wep.wepasppanel.pomclasses.UploadInformation_Page;
import com.wep.wepasppanel.pomclasses.Users;
import com.wep.wepasppanel.pomclasses.Add_PAN_Page;
import com.wep.wepasppanel.pomclasses.CustomerManagement;
import com.wep.wepasppanel.pomclasses.GSTRUploads_GSTR1;
import com.wep.wepasppanel.pomclasses.GSTR_Downloads;
import com.wep.wepasppanel.pomclasses.CreateAccount;
import com.wep.wepasppanel.pomclasses.HSN_Master_Page;

public class TestCase extends Browser_Initialization
{

	
	
	/**@(priority=0)
	 * calling DataProvider RegistrationAccount 
	 * @param Cname
	 * @param Designation
	 * @param Compname
	 * @param Email
	 * @param Mobilenumber
	 * @param compaddress
	 * @param gstname
	 * @param gstno
	 * @param cgstNo
	 * @param pancard
	 * @param State
	 * @throws Exception 
	 * @Calling Method:Customerregistration from CustomerRegistration Class
	 */
	//@Test(dataProvider="RegistrationAccount", dataProviderClass=Dataproviders.class,priority=1)
	public void Account_Registration(String Cname,String Designation,String Compname,String Email,String Mobilenumber,String compaddress, String gstname, String gstno,String Cgstno) throws Exception
	{
		//System.out.println("Started Testing");
		Boolean res=new CreateAccount(driver).Customerregistration(Cname, Designation,Compname,Email,Mobilenumber,compaddress,gstname,gstno,Cgstno);
		ExcelUtils.writeExcelDataRevised(path+LoadConstantsData.readData(Constants.InputFilePath), LoadConstantsData.readData(Constants.PANSheet), LoadConstantsData.readData(Constants.AddPANDeatils), res,path+LoadConstantsData.readData(Constants.OutputFilePath));
		
		System.out.println(res);
	}
		
	
	/**
	 * @param usr
	 * @param pwd
	 * @throws Exception
	 */
	@Test(dataProvider="LoginDataProvider", dataProviderClass=Dataproviders.class, priority=2)
	public void Login(String usr, String pwd,String Expected) throws Exception
	{
	
		Boolean res=new Login_Page(driver).Login(usr,pwd,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	

	//@Test(dataProvider="AddPANNumber", dataProviderClass=Dataproviders.class, priority=3)
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
		ExcelUtils.writeExcelDataRevised(path+LoadConstantsData.readData(Constants.InputFilePath), LoadConstantsData.readData(Constants.PANSheet), LoadConstantsData.readData(Constants.AddPANDeatils), res,path+LoadConstantsData.readData(Constants.OutputFilePath));
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();

	}
	
	//@Test(dataProvider="EditPANNumber", dataProviderClass=Dataproviders.class, priority=4)
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
	
	//@Test(dataProvider="DeletePANNumber", dataProviderClass=Dataproviders.class, priority=5)
	/**
	 * @param PANToBeEdited
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void Delete_PAN_Details(String PANToBeEdited) throws IOException, InterruptedException
	{
			Boolean res=new Add_PAN_Page(driver).delete_PAN_Details(PANToBeEdited);
			//GetTestData.writeData(path+LoadConstantsData.readData(Constants.InputFilePath), LoadConstantsData.readData(Constants.LoginSheet), LoadConstantsData.readData(Constants.LoginTable), res.toString(), path+LoadConstantsData.readData(Constants.OutputFilePath));
			System.out.println(res);
	}
	
	//@Test(dataProvider="AddGSTN", dataProviderClass=Dataproviders.class, priority=6)
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
		//softassert1.assertAll();
		
	}
	
  //@Test(dataProvider="EditGSTN", dataProviderClass=Dataproviders.class, priority=7)
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
	
	//@Test(dataProvider="DeleteGSTN", dataProviderClass=Dataproviders.class, priority=8)
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
	
	//@Test(dataProvider="HSN_Rate_Finder", dataProviderClass=Dataproviders.class, priority=9)
	/**
	 * @param HSN_Code
	 * @throws InterruptedException
	 */
	public void HSN_Rate_Finder(String HSN_Code, String ExpectedResult) throws InterruptedException
	{
		Boolean res= new HSN_Master_Page(driver).HSN_Rate_Finder_Search(HSN_Code);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	//@Test(dataProvider="HSN_Creation", dataProviderClass=Dataproviders.class, priority=10)
	/**
	 * @param HSN_Type
	 * @param HSN_Entry
	 * @param HSN_Code
	 * @param HSN_Desc
	 * @param rate
	 * @throws InterruptedException
	 */
	public void HSN_Creation(String HSN_Type,String HSN_Entry,String HSN_Code, String HSN_Desc, String rate,String ExpectedResult) throws InterruptedException
	{
		Boolean res= new HSN_Master_Page(driver).HSN_Creation(HSN_Type,HSN_Entry,HSN_Code,HSN_Desc,rate,ExpectedResult);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	//@Test(dataProvider="Edit_HSN_Details", dataProviderClass=Dataproviders.class, priority=11)
	/**
	 * @param HSN_Code
	 * @param HSN_Desc
	 * @param rate
	 * @param HSN_Type
	 * @throws InterruptedException
	 */
	public void Edit_HSN_Details(String HSN_Code,String HSN_Desc, String rate,String HSN_Type,String ExpectedResult) throws InterruptedException
	{
		Boolean res= new HSN_Master_Page(driver).edit_HSN_Details(HSN_Code,HSN_Desc,rate,HSN_Type,ExpectedResult);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	/**
	 * 
	 * @param HSN_Code
	 * @param HSN_Desc
	 * @param rate
	 * @param HSN_Type
	 * @throws InterruptedException
	 */
	//@Test(dataProvider="Delete_HSN_Details", dataProviderClass=Dataproviders.class, priority=12)
	public void Delete_HSN_Details(String HSN_Code,String HSN_Desc, String rate,String HSN_Type, String ExpectedResult) throws InterruptedException
	{
		Boolean res= new HSN_Master_Page(driver).delete_HSN_Details(HSN_Code,HSN_Desc,rate,HSN_Type);
		softassert1.assertEquals(res.toString(), ExpectedResult);
		softassert1.assertAll();
	}
	
	
	
	/**@(priority=6)
	 * @calling DataProvider CustomerDetails
	 * @param CName
	 * @param email
	 * @param MobileNo
	 * @param GSTIN
	 * @param ConstitutionBusiness
	 * @param Nature_of_Business
	 * @param ContactPerson
	 * @param address
	 * @throws Exception
	 * @Calling Method:Add_CompanyDetails from CustomerManagement Class
	 */
	//@Test(dataProvider="CustomerDetails", dataProviderClass=Dataproviders.class, priority=14)
	public void Customer_Company_Details(String CName, String email, String MobileNo, String GSTIN, String State, String PancardNumber,  String ConstitutionBusiness, String Nature_of_Business, String ContactPerson,
					 String address,String Expected) throws  Exception
	{
				Boolean res= new CustomerManagement(driver).Add_CompanyDetails(CName, email, MobileNo, GSTIN,State,PancardNumber,ConstitutionBusiness,Nature_of_Business,ContactPerson,address,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				//softassert1.assertAll();
	}
		
	//@Test(dataProvider="EditCustomerDetails", dataProviderClass=Dataproviders.class, priority=14)
	public void EditCustomerDetails(String CName, String Nature_of_Business, String ConstitutionBusiness, String Address, String DOR,String contactPerson, String Expected) throws  Exception
	{
				Boolean res= new CustomerManagement(driver).EditCustomerDetails(CName, Nature_of_Business,ConstitutionBusiness,Address, DOR, contactPerson,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				//softassert1.assertAll();
	}
	
	//@Test(dataProvider="DeleteCustomerDetails", dataProviderClass=Dataproviders.class, priority=14)
	public void DeleteCustomerDetails(String CName, String Expected) throws  Exception
	{
				Boolean res= new CustomerManagement(driver).DeleteCustomerDetails(CName);
				softassert1.assertEquals(res.toString(), Expected);
				//softassert1.assertAll();
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
					
	//@Test(dataProvider="SupplierDetails", dataProviderClass=Dataproviders.class, priority=15)
	public void Supplier_Company_Details(String CName, String email, String MobileNo, String GSTIN,String state,String pancard, String ConstitutionBusiness, String Nature_of_Business, String ContactPerson,
				 String address,String Expected) throws  Exception
	{
				Boolean res= new SupplierManagement(driver).Add_SupplierDetails(CName, email, MobileNo, GSTIN, state, pancard, ConstitutionBusiness, Nature_of_Business, ContactPerson, address,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
		
	//@Test(dataProvider="EditSupplierDetails", dataProviderClass=Dataproviders.class, priority=15)
	public void EditSupplierDetails(String CName, String ConstitutionBusiness, String Nature_of_Business, String ContactPerson, String address,String DOR,String Expected) throws  Exception
	{
				Boolean res= new SupplierManagement(driver).EditSupplierDetails(CName, Nature_of_Business, ConstitutionBusiness, address,DOR, ContactPerson,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
	
	//@Test(dataProvider="DeleteSupplierDetails", dataProviderClass=Dataproviders.class, priority=15)
	public void DeleteSupplierDetails(String CName, String Expected) throws  Exception
	{
				Boolean res= new SupplierManagement(driver).DeleteSupplierDetails(CName);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
	
	
			
			/**@(priority=8)
			 *  @calling DataProvider UserRoleCreation
			 * @param addrole
			 * @throws Exception
			 * @Calling Method:Add_Roles from Users Class
			 */
	//@Test(dataProvider="UserRoleCreation", dataProviderClass=Dataproviders.class, priority=16)
	public void Role_Details(String addrole,String Expected) throws Exception
	{
				Boolean res = new Users(driver).Add_Roles(addrole,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
				
	}
			
	/**@(priority=8)
	 *  @calling DataProvider UserRoleCreation
	 * @param addrole
	 * @throws Exception
	 * @Calling Method:Add_Roles from Users Class
	 */
//@Test(dataProvider="UserRoleDeletion", dataProviderClass=Dataproviders.class, priority=16)
public void Delete_Role(String roleName,String Expected) throws Exception
{
		Boolean res = new Users(driver).Delete_Roles(roleName,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
		
}		
			
			/**@(priority=9)
			 *@calling DataProvider AddUserRegistration 
			 * @param nameofperson
			 * @param designation
			 * @param emailid
			 * @param password
			 * @param mobileno
			 * @throws Exception
			 *  @Calling Method:User_RegistrationPage from Users Class
			 * 
			 */
	//@Test(dataProvider="AddUserRegistration", dataProviderClass=Dataproviders.class, priority=17)
	public void User_Registration_Details(String nameofperson,String designation, String emailid, String password, String mobileno,String roleName,String GSTN,String Expected) throws Exception
	{
				Boolean res = new Users(driver).User_RegistrationPage(nameofperson, designation, emailid, password, mobileno,roleName,GSTN,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
			
			
			/**@(priority=10)
			 * @calling DataProvider EditUserRegistration 
			 * @param editby
			 * @param name
			 * @param designation
			 * @param emailid
			 * @param password
			 * @param mobileno
			 * @throws Exception
			 * @Calling Method:Edit_Username from Users Class
			 */
	//@Test(dataProvider="EditUserRegistration", dataProviderClass=Dataproviders.class, priority=18)
	public void Edit_User_Details(String editby,String name, String designation, String emailid, String password, String mobileno,String Expected)throws Exception
	{
				Boolean res = new Users(driver).Edit_Username(editby, name, designation, emailid, password, mobileno,Expected);
				softassert1.assertEquals(res.toString(), Expected);
				softassert1.assertAll();
	}
			
			
			
			/**@(priority=11)
			 * @calling DataProvider DeleteUser_Registration 
			 * @param Designation_Number
			 * @throws Exception
			 *  @Calling Method:Delete_User_Details from Users Class
			 */
			
	//@Test(dataProvider="DeleteUser_Registration", dataProviderClass=Dataproviders.class, priority=19)
	public void Delete_User_Details(String Designation_Number, String Expected)throws Exception
	{
		Boolean res = new Users(driver).Delete_User_Details(Designation_Number);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
			
			
			
			/**@(priority=12)
			 * @calling DataProvider BlockandUnblock_Page
			 * @param editby
			 * @throws Exception
			 * @Calling Method:BlockandUnblockUser from Users Class
			 */
		
	//@Test(dataProvider="BlockandUnblockUser", dataProviderClass=Dataproviders.class, priority=20)
	public void Block_UnBlock_Users(String Username, String Expected)throws Exception
	{
			Boolean res = new Users(driver).BlockandUnblockUser(Username,Expected);
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}
			
	
	
	
		/**@(priority=16)
		 *@calling DataProvider Sales_Summary_Report
		 * @param Period
		 * @throws Exception
		 * @Calling Method:Sales_Summary from Reports Class
		 */
	//@Test(dataProvider="Reports", dataProviderClass=Dataproviders.class, priority=24)
	public void GSTIN_Sales_Summary(String  Period,String GSTINNo, String Expected)throws Exception
	{
		System.out.println("Inside testcase");
		Boolean res = new Report_Page(driver).GSTIN_Sales_SummaryReport(Period, GSTINNo);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
		
	//@Test(dataProvider="Reports", dataProviderClass=Dataproviders.class, priority=24)
	public void GSTIN_Purchase_Summary(String  Period,String GSTINNo, String Expected)throws Exception
	{
		Boolean res = new Reports(driver).GSTIN_Purchase_Summary(Period, GSTINNo);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}	
		/**@(priority=17)
		 * @calling DataProvider Sales_Summary_InvoiceType
		 * @param Period
		 * @throws Exception
		 * @Calling Method:Sales_Summary_InvoiceType from Reports Class
		 */
	//@Test(dataProvider="Reports", dataProviderClass=Dataproviders.class, priority=24)
	public void Sales_Summary_Invoice_Type(String  Period, String GSTINNo, String Expected)throws Exception
	{
			Boolean res = new Reports(driver).Sales_Summary_InvoiceType(Period, GSTINNo);
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}
		
		
		/**@(priority=18)
		 * @calling DataProvider Customer_Sales_Report
		 * @param Period
		 * @throws Exception
		 * Calling Method:Customers_Sales_Report from Reports Class
		 */
		
	//@Test(dataProvider="Reports", dataProviderClass=Dataproviders.class, priority=24)
    public void Customer_Sales_Report(String  Period, String GSTINNo, String Expected)throws Exception
	{
			Boolean res = new Reports(driver).Customer_Sales_Report(Period, GSTINNo);
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}
		
		
		
		/**@(priority=19)
		 * @calling DataProvider Supplier_Inward_Method
		 * @param Period
		 * @throws Exception
		 * Calling Method:Supplier_Inward from Reports Class
		 */
	//@Test(dataProvider="Reports", dataProviderClass=Dataproviders.class, priority=24)
	public void Supplier_Inward_Register(String  Period, String GSTINNo, String Expected)throws Exception
	{
			Boolean res = new Reports(driver).Supplier_Inward_Register(Period, GSTINNo);
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}
		
	//@Test(dataProvider="Audit_Log_Report", dataProviderClass=Dataproviders.class, priority=24)
	public void AuditReport(String  fromDate, String toDate, String Expected)throws Exception
	{
			Boolean res = new Reports(driver).Audit_Log_Report(fromDate, toDate);
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}	
	
	//@Test(dataProvider="Reports", dataProviderClass=Dataproviders.class, priority=24)
	public void LogReport(String  Period, String GSTINNo, String Expected)throws Exception
	{
			Boolean res = new Reports(driver).Log_List(Period);
			softassert1.assertEquals(res.toString(), Expected);
			softassert1.assertAll();
	}	
		/**@(priority=20)
		 * @calling DataProvider Logout_Methods
		 * @Calling Method:logout from LoginPage Class
		 */
	
	//@Test(dataProvider="CreateATDetails", dataProviderClass=Dataproviders.class, priority=20)
	public void CreateATDetails(String GSTINNo, String period, String type, String rate, String pos, String advance_amount, String cess_amount,String Expected) throws Exception
	{
		Boolean res = new Outward_Register_Page(driver).Create_ATTXP_Invoices(GSTINNo, period, type, rate, pos, advance_amount, cess_amount);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
			
	}	
	
	//@Test(dataProvider="Edit_AT_TXP_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void EditATDetails(String GSTINNo, String period, String type, String rate, String pos, String advance_amount, String cess_amount, String action_name,String Expected) throws Exception
	{
		Boolean res = new Outward_Register_Page(driver).Edit_AT_Invoices(GSTINNo, period, type, rate, pos, advance_amount, cess_amount, action_name);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
			
	}
	
	//@Test(dataProvider="Delete_AT_TXP_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void Delete_AT_TXP_Invoices(String type, String GSTINNo, String period, String Expected) throws Exception
	{
		Boolean res = new Outward_Register_Page(driver).Delete_AT_Invoices(type, GSTINNo, period);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
			
	}
	
	//@Test(dataProvider="CreateDocIssue", dataProviderClass=Dataproviders.class, priority=20)
	public void CreateDocIssue(String GSTINNo, String Period, String DocType, String FromSerialNo, String ToSerialNo, String TotalInvCount, String Cancelled,String Expected) throws Exception
	{
		Boolean res = new Outward_Register_Page(driver).Create_Doc_Issue_Invoices(GSTINNo, Period, DocType,FromSerialNo, ToSerialNo, TotalInvCount, Cancelled);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}	
	
	//@Test(dataProvider="Edit_DocIssue_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void EditDocIssue(String GSTINNo, String Period, String DocType, String FromSerialNo, String ToSerialNo, String TotalInvCount, String Cancelled, String action_name,String Expected) throws Exception
	{
		Boolean res = new Outward_Register_Page(driver).Edit_DocIssue_Invoices(GSTINNo, Period, DocType, FromSerialNo, ToSerialNo, TotalInvCount, Cancelled, action_name);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
			
	}
	
	//@Test(dataProvider="Delete_DocIssue_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void DeleteDocIssue(String GSTINNo, String period, String Expected) throws Exception
	{
		Boolean res = new Outward_Register_Page(driver).Delete_DocIssue_Invoices(GSTINNo, period);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
			
	}
	
	//@Test(dataProvider="Create_NILRated_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void CreateNiLRatedInvoices(String GSTINNo, String Period, String SupplyType, String NilRatedSupplies, String ExemptedSupplies, String NonGSTSupplies, String Expected) throws Exception
	{
		Boolean res = new NiLRateInvoices_Page(driver).Create_NiLRated_Invoice(GSTINNo, Period, SupplyType, NilRatedSupplies, ExemptedSupplies, NonGSTSupplies);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	
	}
	
	//@Test(dataProvider="Edit_NILRated_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void EditNiLRatedInvoices(String GSTINNo, String Period, String SupplyType, String NilRatedSupplies, String ExemptedSupplies, String NonGSTSupplies, String Expected) throws Exception
	{
		Boolean res = new NiLRateInvoices_Page(driver).Edit_NilRated_Invoices(GSTINNo, Period, SupplyType, NilRatedSupplies, ExemptedSupplies, NonGSTSupplies);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	
	}
	
	//@Test(dataProvider="Delete_NILRated_Invoices", dataProviderClass=Dataproviders.class, priority=20)
	public void DeleteNiLRatedInvoices(String GSTINNo, String Period, String SupplyType, String Expected) throws Exception
	{
		Boolean res = new NiLRateInvoices_Page(driver).Delete_NiLRated_Invoices(GSTINNo, Period, SupplyType);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	
	}
	
	
	@Test(dataProvider="ImportFiles", dataProviderClass=Dataproviders.class)
	/**
	 * @param GSTR_Type
	 * @param Action
	 * @param File_path
	 * @throws InterruptedException
	 */
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
	
	@Test(dataProvider="GSTR1Download", dataProviderClass=Dataproviders.class)
	public void GSTR1Download(String GSTINNo,String Period, String Action, String ReferenceId, String Expected) 
	{
		Boolean res= new GSTR_Downloads(driver).GSTR1_Download(GSTINNo, Period, Action, ReferenceId);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	@Test( priority=29)
	public void logout()
	{
		Boolean res=new Login_Page(driver).logout();
		System.out.println(res);
	}
}
