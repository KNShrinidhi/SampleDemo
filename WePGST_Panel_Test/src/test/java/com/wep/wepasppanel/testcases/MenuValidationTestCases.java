package com.wep.wepasppanel.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wep.wepasppanel.dataproviders.Dataproviders;
import com.wep.wepasppanel.pomclasses.Add_GSTIN_Page;
import com.wep.wepasppanel.pomclasses.Add_PAN_Page;
import com.wep.wepasppanel.pomclasses.CustomerManagement;
import com.wep.wepasppanel.pomclasses.DownloadDocuments_Page;
import com.wep.wepasppanel.pomclasses.EWayBill_Page;
import com.wep.wepasppanel.pomclasses.GSTINTallyConverter_Page;
import com.wep.wepasppanel.pomclasses.GSTR3B_Page;
import com.wep.wepasppanel.pomclasses.GSTRUploads_Page;
import com.wep.wepasppanel.pomclasses.GSTR_Downloads;
import com.wep.wepasppanel.pomclasses.HSN_Master_Page;
import com.wep.wepasppanel.pomclasses.InwardRegister_Page;
import com.wep.wepasppanel.pomclasses.Login_Page;
import com.wep.wepasppanel.pomclasses.Outward_Register_Page;
import com.wep.wepasppanel.pomclasses.Reconciliation_Page;
import com.wep.wepasppanel.pomclasses.Report_Page;
import com.wep.wepasppanel.pomclasses.SupplierManagement;
import com.wep.wepasppanel.pomclasses.UploadInformation_Page;
import com.wep.wepasppanel.pomclasses.Users;

public class MenuValidationTestCases extends Browser_Initialization
{
	public SoftAssert softassert1= new SoftAssert();
	
	@Test(dataProvider="LoginDataProvider", dataProviderClass=Dataproviders.class, priority=1)
	public void Login(String usr, String pwd,String Expected) throws Exception
	{
		Boolean res=new Login_Page(driver).Login(usr,pwd,Expected);
		softassert1.assertEquals(res.toString(), Expected);
		softassert1.assertAll();
	}
	
	@Test(priority=2)
	public void PAN_MenuClick()
	{
		Boolean res=new Add_PAN_Page(driver).PAN_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=3)
	public void GSTIN_MenuClick() throws InterruptedException
	{
		Boolean res=new Add_GSTIN_Page(driver).GSTN_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=4)
	public void CustomerManagement_MenuClick() throws Exception
	{
		Boolean res=new CustomerManagement(driver).Customer_Management_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=5)
	public void SupplierManagement_MenuClick() throws Exception
	{
		Boolean res=new SupplierManagement(driver).Supplier_Management_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=6)
	public void HSNRateFinder_MenuClick()
	{
		Boolean res=new HSN_Master_Page(driver).HSN_Rate_Finder_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=7)
	public void HSNCreation_MenuClick()
	{
		Boolean res=new HSN_Master_Page(driver).HSN_Creation_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	//@Test(priority=8)
	public void Role_MenuClick() throws InterruptedException
	{
		Boolean res=new Users(driver).Role_Creation_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	//@Test(priority=9)
	public void UserCreation_MenuClick() throws InterruptedException
	{
		Boolean res=new Users(driver).User_Registration_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	//@Test(priority=10)
	public void BlockUnblockUser_MenuClick() throws InterruptedException
	{
		Boolean res=new Users(driver).Block_and_UnBlock_User_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=11)
	public void B2BInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).B2BInvoice_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=12)
	public void B2CLInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).B2CLInvoice_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=13)
	public void B2CSInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).B2CSInvoice_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=14)
	public void ATTXPInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).ATandTXP_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=15)
	public void DocIssueInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).DocIssue_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=16)
	public void CreditDebitNote_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).CDNRInvoice_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
		
	@Test(priority=17)
	public void ExpInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).ExpInvoice_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=18)
	public void NILRatedInvoice_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).NilRate_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=19)
	public void InvoiceGeneration_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).InvoiceGeneration_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=20)
	public void GSTR1DataEdit_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).GSTR1DataEdit_menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	
	
	////@Test(priority=21)
	public void InvoiceSetting_MenuClick()
	{
		Boolean res=new Outward_Register_Page(driver).InvoiceSetting_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=21)
	public void B2BSupplierInvoice_MenuClick()
	{
		Boolean res=new InwardRegister_Page(driver).B2BSupplierInvoice_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=22)
	public void ReverseCharge_MenuClick()
	{
		Boolean res=new InwardRegister_Page(driver).ReverseChargeInvoice_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	//@Test(priority=24)
	public void ConvertCSV_MenuClick()
	{
		Boolean res=new GSTINTallyConverter_Page(driver).ConvertCSV_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	//@Test(priority=25)
	public void GSTRUpload_MenuClick()
	{
		Boolean res=new GSTINTallyConverter_Page(driver).GSTRUpload_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=26)
	public void GSTRCSVUpload_MenuClick()
	{
		Boolean res= new UploadInformation_Page(driver).GSTR_CSV_Upload_Menu();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=27)
	public void CTINValidation_MenuClick()
	{
		Boolean res=new UploadInformation_Page(driver).GSTINValidation_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=28)
	public void DeviceUpload_MenuClick()
	{
		Boolean res=new UploadInformation_Page(driver).DeviceUpload_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=29)
	public void InvoiceDataCorrection_MenuClick()
	{
		Boolean res=new Reconciliation_Page(driver).InvoiceDataCorrection_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=30)
	public void InvoiceValueCorrection_MenuClick()
	{
		Boolean res=new Reconciliation_Page(driver).InvoiceValueCorrection_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=31)
	public void ReconciliationSetting_MenuClick()
	{
		Boolean res=new Reconciliation_Page(driver).ReconciliationSetting_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=32)
	public void Reconciliation_MenuClick()
	{
		Boolean res=new Reconciliation_Page(driver).Reconciliation_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=33)
	public void UpdateITC_MenuClick()
	{
		Boolean res=new Reconciliation_Page(driver).UpdateITC_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=34)
	public void GSTR1Save_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR1Save_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=35)
	public void GSTR1View_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR1View_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=36)
	public void GSTR1File_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR1File_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=37)
	public void GSTR2Save_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR2Save_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=38)
	public void GSTR2File_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR2File_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=39)
	public void GSTR1ASave_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR1ASave_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=40)
	public void GSTR1AFile_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR1AFile_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=41)
	public void GSTR3Save_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR3Save_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=42)
	public void GSTR3File_MenuClick()
	{
		Boolean res=new GSTRUploads_Page(driver).GSTR3File_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=43)
	public void GSTR1Download_MenuClick()
	{
		Boolean res=new GSTR_Downloads(driver).GSTR1Download_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=44)
	public void GSTR2ADownload_MenuClick()
	{
		Boolean res=new GSTR_Downloads(driver).GSTR2ADownload_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=45)
	public void GSTR2Download_MenuClick()
	{
		Boolean res=new GSTR_Downloads(driver).GSTR2Download_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=46)
	public void GSTR1ADownload_MenuClick()
	{
		Boolean res=new GSTR_Downloads(driver).GSTR1ADownload_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=47)
	public void GSTR3Download_MenuClick()
	{
		Boolean res=new GSTR_Downloads(driver).GSTR3Download_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=48)
	public void ViewTrackStatus_MenuClick()
	{
		Boolean res=new GSTR_Downloads(driver).TrackStatus_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=49)
	public void GSTR3BSave_MenuClick()
	{
		Boolean res=new GSTR3B_Page(driver).GSTR3BSave_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=50)
	public void GSTR3BDownload_MenuClick()
	{
		Boolean res=new GSTR3B_Page(driver).GSTR3BDownload_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=51)
	public void GSTR3BDashboard_MenuClick()
	{
		Boolean res=new GSTR3B_Page(driver).GSTR3BDashboard_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=52)
	public void GSTR3BReport_MenuClick()
	{
		Boolean res=new GSTR3B_Page(driver).GSTR3BReport_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=53)
	public void EWayBillDashboard_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).EWayBillDashBoard_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=54)
	public void EWayBillGeneration_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).EWayBillGeneration_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=55)
	public void EWayBillList_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).EWayBillList_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	
	@Test(priority=56)
	public void EWayBillCancelPrint_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).EWayBillCancelPrint_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	
	@Test(priority=57)
	public void EWayBillReject_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).EWayBillReject_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=58)
	public void GSTINSalesSummary_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).GSTIN_Sales_Summary_Menu_Click();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=59)
	public void GSTINPurchaseSummary_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).GSTIN_Purchase_Summary_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=60)
	public void SalesSummaryInvoicewise_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).Sales_Summary_InvoiceType_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=61)
	public void CustomerSalesReport_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).Customer_Sales_Report_B2B_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=62)
	public void SupplierInward_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).Supplier_Inward_Register_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=63)
	public void AuditLogReport_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).AuditLog_MenuList();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=64)
	public void LogReport_MenuClick() throws Exception
	{
		Boolean res=new Report_Page(driver).LogFiles_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=65)
	public void DownloadDocument_MenuClick() throws Exception
	{
		Boolean res=new DownloadDocuments_Page(driver).DownloadDocuments_menuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=66)
	public void ConsEwayBill_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).ConsEWayBillGeneration_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=67)
	public void BulkUpload_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).BulkUpload_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=68)
	public void VehicleUpdate_MenuClick()
	{
		Boolean res=new EWayBill_Page(driver).UpdateVehicleNo_MenuClick();
		softassert1.assertEquals(res.toString(), "true");
		softassert1.assertAll();
	}
	
	@Test(priority=69)
	public void logout()
	{
		Boolean res=new Login_Page(driver).logout();
		System.out.println(res);
	}
}
