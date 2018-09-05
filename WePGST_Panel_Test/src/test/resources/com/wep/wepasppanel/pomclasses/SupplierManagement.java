package com.wep.wepasppanel.pomclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;
/**
 * 
 * @author Harish Takle
 *
 */

public class SupplierManagement {

	public WebDriver driver;
	
	/**
	 * All the Elements path
	 */
	
	@FindBy(xpath="//*[@title='Supplier Management']")
	WebElement SupplierManagement;
	
	@FindBy(xpath=".//h2[text()='Supplier Creation']")
	WebElement Suppliercreationpage;
	
	@FindBy(xpath="//*[@placeholder='Supplier Name']")
	WebElement Suppliername; 
	
	@FindBy(xpath="//*[@placeholder='Email']")
	WebElement email;
	
	@FindBy(xpath="//*[@placeholder='Mobile Number']")
	WebElement Mobilenumber;
	
	@FindBy(xpath="//*[@placeholder='GSTIN']")
	WebElement GstIN;
	
	@FindBy(xpath="//input[@id='cob']")
	WebElement ConstitutionofBusiness;
	
	@FindBy(xpath="//input[@id='nob']")
	WebElement NatureofBusiness;
	
	@FindBy(xpath=".//*[@id='date']")
	WebElement DateofRegistration;
	
	@FindBy(xpath="//*[@placeholder='Contact Person']")
	WebElement Contactperson;
	
	@FindBy(xpath="//*[@placeholder='Address']")
	WebElement Address;
	
	@FindBy(xpath="//*[@name='Create']")
	WebElement CreateButton;
	
	@FindBy(xpath="//*[@name='FileUpload']")
	WebElement FileUpload;
	
	@FindBy(xpath="//*[@id='btnUpload']")
	WebElement UploadFile;
	
	//Edit and Delete Customer details
	
		@FindBy(xpath="//input[@id='SupplierName']")
		WebElement companyName;
		
		@FindBy(xpath="//input[@id='NatureOfBusiness']")
		WebElement natureOfBusiness;
		
		@FindBy(xpath="//input[@id='ConstitutionOfBusiness']")
		WebElement constitutionOfBusiness;
		
		@FindBy(xpath="//input[@id='Address']")
		WebElement addressTextbox;
		
		@FindBy(xpath="//input[@id='DateofCompRegistered']")
		WebElement dateOfRegistration;
		
		@FindBy(xpath="//input[@id='POCName']")
		WebElement contactPerson;
		
		@FindBy(xpath="//input[@value='Update']")
		WebElement updateButton;
		
		@FindBy(xpath="//a[@class='btn btn-success btnstyle']")
		WebElement cancelButton;
		
		@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
		WebElement confirmButton;
		
		@FindBy(xpath="//input[@type='search']")
		WebElement searchTextBox;
		
		@FindBy(xpath=".//input[@id='Delete']")
		public WebElement deleteButton;
		
		@FindBy(xpath=".//input[@id='Edit']")
		public WebElement editButton;
		
		@FindBy(xpath=".//p[@class='lead text-muted ']")
		public WebElement confirmDialogBox;
		
		@FindBy(xpath=".//button[@class='confirm btn btn-lg btn-danger']")
		public WebElement buttonOnPopup;
		
		@FindBy(xpath=".//button[@class='cancel btn btn-lg btn-default']")
		public WebElement cancelOnPopup;
		
		@FindBy(xpath=".//table[@id='example']/tbody/tr[1]/td[1]")
		public List<WebElement> resultList;
	
	Screenshot screenshot=new Screenshot();
	
	/**
	 * @Constructor 
	 * @param driver
	 */
	public SupplierManagement(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * @Method:Verification_of_Title
	 * @return
	 * @throws Exception 
	 */
	public Boolean Supplier_Management_Click() throws Exception
	{
		SupplierManagement.click();
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.SupplierManagementPage)))
		return true;
		else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				return false;
			}
	}
	
	
	/**
	 * 
	 * @Method:Adding the Supplier Details
	 * @return
	 * @throws Exception 
	 */
	public Boolean Add_SupplierDetails(String supplierName , String Email, String MobileNumber , String GSTIN,String State,String  PancardNumber, String ConstitutionBusiness, String Nature_of_Business , String ContactPerson,
			 String address,String Expected) throws Exception
				{
					Boolean res=Supplier_Management_Click();
					if(res)
					{
		
						Suppliername.sendKeys(supplierName);
						Thread.sleep(1000);
						
					
						email.sendKeys(Email);
						Thread.sleep(1000);
						
				
						Mobilenumber.sendKeys(MobileNumber);
						
						
						GstIN.sendKeys(GSTIN);
						Thread.sleep(2000);
						
						DateofRegistration.click();
						
						Contactperson.sendKeys(ContactPerson);
				
						Address.sendKeys(address);
					
						CreateButton.click();
						
					/*	if(driver.switchTo().alert().getText().equalsIgnoreCase("Supplier Registered Successfully"))
						{
							driver.switchTo().alert().accept();
							return true;
						}
						else{
							return false;
						}*/
					}
					/*
					    FileUpload.click();
						FileUpload.click();
						Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\GST_Automation\\testdata\\SupplierExcelUpload.exe");
						Thread.sleep(3000);
						
						UploadFile.click();
					*/	
						
						
					
					
					
				
					
		return false;
	}
				
	public Boolean SearchSupplierDetails(String searchValue)
	{
		
		searchTextBox.clear();
		searchTextBox.sendKeys(searchValue);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultList.size()==1 & !(resultList.get(0).getText().equalsIgnoreCase("No matching records found")))
			return true;
		else
			return false;
		
		
	}
	
	public Boolean EditSupplierDetails(String CompanyName, String Nature_of_Business, String ConstitutionBusiness, String address, String DOR,String ContactPerson,String Expected) throws Exception
	{
		Boolean res=Supplier_Management_Click();
		
		if(res)
		{
			res=SearchSupplierDetails(CompanyName);
			if(res)
			{
				editButton.click();
				
				Thread.sleep(2000);
				if(confirmDialogBox.getText().equalsIgnoreCase("Are you sure that you want to Edit this Record?"))
				{
					buttonOnPopup.click();
					
					Thread.sleep(2000);
					
					companyName.clear();
					companyName.sendKeys(CompanyName);
					
					natureOfBusiness.clear();
					natureOfBusiness.sendKeys(Nature_of_Business);
					
					constitutionOfBusiness.clear();
					constitutionOfBusiness.sendKeys(ConstitutionBusiness);
					
					addressTextbox.clear();
					addressTextbox.sendKeys(address);
					
					dateOfRegistration.clear();
					dateOfRegistration.sendKeys(DOR);
					
					contactPerson.clear();
					contactPerson.sendKeys(ContactPerson);
					
					updateButton.click();
					
					Thread.sleep(2000);
					if(confirmDialogBox.getText().equalsIgnoreCase("Supplier Details Updated Successfully"))
					{
						confirmButton.click();
						return true;
					}
					else
					{
						screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
						return false;
					}
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					return false;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				return false;
			}
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}
	
	public Boolean DeleteSupplierDetails(String companyName)
	{
		Boolean res=false;
		try {
			res = Supplier_Management_Click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(res)
		{
			res=SearchSupplierDetails(companyName);
			if(res)
			{
				deleteButton.click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(confirmDialogBox.getText().equalsIgnoreCase("Are you sure that you want to delete this Record?"))
				{
					buttonOnPopup.click();
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(SearchSupplierDetails(companyName))
					{
						screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
						return false;
					}
					else
					{
						return true;
					}
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					return false;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				return false;
			}
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}		
					
	}
					
	
