package com.wep.wepasppanel.dataproviders;

import org.testng.annotations.DataProvider;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.excelreader.ExcelUtils;
import com.wep.wepasppanel.testcases.Browser_Initialization;

/**
 * @author KK
 *
 */
public class Dataproviders  extends Browser_Initialization
{
	public String FilePath=path+LoadConstantsData.readData(Constants.InputFilePath);
	public String OutPutFilePath=path+LoadConstantsData.readData(Constants.OutputFilePath);
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="RegistrationAccount")
	public Object[][] CustomerRegistrationDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.CustomerRegistrationSheet);
		String TableName=LoadConstantsData.readData(Constants.CustomerRegistration);
		Object[][] CustomerRegistration =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		
		return CustomerRegistration;
	
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="LoginDataProvider")
	public Object[][] LoginData() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.LoginSheet);
		String TableName=LoadConstantsData.readData(Constants.LoginDetails);
		Object[][] login =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return login;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="AddPANNumber")
	public Object[][] addPANDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.PANSheet);
		String TableName=LoadConstantsData.readData(Constants.AddPANDeatils);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="EditPANNumber")
	public Object[][] editPANDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.PANSheet);
		String TableName=LoadConstantsData.readData(Constants.EditPANDetails);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="DeletePANNumber")
	public Object[][] deletePANDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.PANSheet);
		String TableName=LoadConstantsData.readData(Constants.DeletePANDetails);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
		
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="AddGSTN")
	public Object[][] addGSTNDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.GSTNSheet);
		String TableName=LoadConstantsData.readData(Constants.AddGSTNDetails);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="EditGSTN")
	public Object[][] editGSTNDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.GSTNSheet);
		String TableName=LoadConstantsData.readData(Constants.EditGSTNDetails);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="DeleteGSTN")
	public Object[][] deleteGSTNDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.GSTNSheet);
		String TableName=LoadConstantsData.readData(Constants.DeleteGSTNDetails);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="HSN_Rate_Finder")
	public Object[][] HSN_Rate_Finder() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.HSNMasterSheet);
		String TableName=LoadConstantsData.readData(Constants.HSN_Rate_Finder_Details);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="HSN_Creation")
	public Object[][] Create_HSN_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.HSNMasterSheet);
		String TableName=LoadConstantsData.readData(Constants.HSN_Creation_Details);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="Edit_HSN_Details")
	public Object[][] Edit_HSN_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.HSNMasterSheet);
		String TableName=LoadConstantsData.readData(Constants.Edit_HSN_Details);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="Delete_HSN_Details")
	public Object[][] Delete_HSN_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.HSNMasterSheet);
		String TableName=LoadConstantsData.readData(Constants.Delete_HSN_Details);
		Object[][] PANDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return PANDetails;
	}
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="CustomerDetails")
	public Object[][] CustomerManagementDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.CustomerManagementSheet);
		String TableName=LoadConstantsData.readData(Constants.CustomerDetails);
		Object[][] CustomerManagement =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return CustomerManagement;
	}
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="SupplierDetails")
	public Object[][] SupplierManagementDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.SupplierManagementSheet);
		String TableName=LoadConstantsData.readData(Constants.SupplierManagement);
		Object[][] SupplierManagement =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return SupplierManagement;
	}
	
	

	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="UserRoleCreation")
	public Object[][] UserRoleCreationDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UserSheetDetails);
		String TableName=LoadConstantsData.readData(Constants.UserRoleCreation);
		Object[][] RoleManagement =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return RoleManagement;
	}
	
	
	@DataProvider(name="UserRoleDeletion")
	public Object[][] UserRoleDeletion() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UserSheetDetails);
		String TableName=LoadConstantsData.readData(Constants.DeleteRole);
		Object[][] RoleManagement =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return RoleManagement;
	}
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="AddUserRegistration")
	public Object[][] AddingUserDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UserSheetDetails);
		String TableName=LoadConstantsData.readData(Constants.UserRegistrationCreation);
		Object[][] userregistration =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return userregistration;
	}
	
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="EditUserRegistration")
	public Object[][] EditUserDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UserSheetDetails);
		String TableName=LoadConstantsData.readData(Constants.EditUserDetails);
		Object[][] edituserregistration =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return edituserregistration;
	}
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="DeleteUser_Registration")
	public Object[][] DeleteUserDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UserSheetDetails);
		String TableName=LoadConstantsData.readData(Constants.DeleteUserDetailsInformation);
		Object[][] deleteuser =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return deleteuser;
	}
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="BlockandUnblockUser")
	public Object[][] BlockandUnblockUser() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UserSheetDetails);
		String TableName=LoadConstantsData.readData(Constants.BlockAndUnblockUser);
		Object[][] edituser =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return edituser;
	}
	
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="Reports")
	public Object[][] Sales_Summary_Report() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.ReportsCreationDetails);
		String TableName=LoadConstantsData.readData(Constants.ReportsDetails);
		Object[][] Sales_Summary_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Sales_Summary_Report;
	}
	
	/**
	 * Reading the values from ExcelSheet and Table
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name="Audit_Log_Report")
	public Object[][] Audit_Log_Report() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.ReportsCreationDetails);
		String TableName=LoadConstantsData.readData(Constants.AuditReport);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="EditCustomerDetails")
	public Object[][] Edit_Customer_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.CustomerManagementSheet);
		String TableName=LoadConstantsData.readData(Constants.EditCustomerDetails);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="DeleteCustomerDetails")
	public Object[][] Delete_Customer_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.CustomerManagementSheet);
		String TableName=LoadConstantsData.readData(Constants.DeleteCustomerDetails);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="EditSupplierDetails")
	public Object[][] Edit_Supplier_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.SupplierManagementSheet);
		String TableName=LoadConstantsData.readData(Constants.EditSupplierDetails);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="DeleteSupplierDetails")
	public Object[][] Delete_Supplier_Details() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.SupplierManagementSheet);
		String TableName=LoadConstantsData.readData(Constants.DeleteSupplierDetails);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	
	@DataProvider(name="CreateATDetails")
	public Object[][] CreateATDetails() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Create_ATTXP_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Edit_AT_TXP_Invoices")
	public Object[][] Edit_AT_TXP_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Edit_ATTXP_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Delete_AT_TXP_Invoices")
	public Object[][] Delete_AT_TXP_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Delete_ATTXP_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="CreateDocIssue")
	public Object[][] CreateDocIssue() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Create_Doc_Issue_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Edit_DocIssue_Invoices")
	public Object[][] Edit_DocIssue_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Edit_Doc_Issue_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Delete_DocIssue_Invoices")
	public Object[][] Delete_DocIssue_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		System.out.println(sheetName);
		String TableName=LoadConstantsData.readData(Constants.Delete_Doc_Issue_Invoices);
		System.out.println(TableName);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Create_NILRated_Invoices")
	public Object[][] Create_NILRated_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Create_NIL_Rated_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Edit_NILRated_Invoices")
	public Object[][] Edit_NILRated_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Edit_NIL_Rated_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
	}
	
	@DataProvider(name="Delete_NILRated_Invoices")
	public Object[][] Delete_NILRated_Invoices() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.Outward_Register_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Delete_NIL_Rated_Invoices);
		Object[][] Audit_Log_Report =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return Audit_Log_Report;
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
	
	@DataProvider(name="ImportFiles")
	public Object[][] Import_Files() throws Exception
	{
		String sheetName=LoadConstantsData.readData(Constants.UploadInformation_Sheet);
		String TableName=LoadConstantsData.readData(Constants.Upload_CSV_File);
		Object[][] ImportFileDetails =ExcelUtils.getTableArrayData(FilePath, sheetName,TableName);
		return ImportFileDetails;
	}	
	
}
