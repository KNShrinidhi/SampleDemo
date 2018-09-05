package com.wep.wepasppanel.pomclasses;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;
import org.openqa.selenium.support.FindBy;

/**
 * @author Harish Takle
 *
 */
public class CustomerManagement 
{
	public WebDriver driver;

	@FindBy(xpath=".//span[text()='Customer Management']")
	WebElement CustomerManagement_Menu;
		
	@FindBy(xpath=".//h2[text()='Customer Registration']")
	WebElement Customerpage;
	
	@FindBy(xpath="//*[@id='name']")
	WebElement Companyname;
		
	@FindBy(xpath="//*[@placeholder='Email']")
	WebElement email;
	
	@FindBy(xpath="//*[@placeholder='Mobile Number ']")
	WebElement Mobilenumber;
	
	@FindBy(xpath="//*[@placeholder='GSTIN']")
	WebElement GstIN;
	
	@FindBy(xpath="//*[@placeholder='State Code']")
	WebElement State_Code;
	
	@FindBy(xpath="//*[@id='pan']")
	WebElement Pancard_Number;
	
	@FindBy(xpath="//*[@placeholder='Constitution of Business']")
	WebElement ConstitutionofBusiness;
	
	@FindBy(xpath="//*[@placeholder='Nature of Business']")
	WebElement NatureofBusiness;
	
	@FindBy(xpath=".//*[@id='date']")
	WebElement DateofRegistration;
	
	@FindBy(xpath=".//*[@id='ui-datepicker-div']")
	WebElement Datepicker;
	
	@FindBy(xpath="//*[@class='ui-state-default ui-state-highlight']")
	WebElement PresentDate;

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
	
	@FindBy(xpath="//input[@id='BuyerName']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@id='NatureOfBusiness']")
	WebElement natureOfBusiness;
	
	@FindBy(xpath="//input[@id='ConstitutionOfBusiness']")
	WebElement constitutionOfBusiness;
	
	@FindBy(xpath="//input[@id='address']")
	WebElement addressTextbox;
	
	@FindBy(xpath="//input[@id='DateofCompRegistered']")
	WebElement dateOfRegistration;
	
	@FindBy(xpath="//input[@id='poc']")
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
	
	@FindBy(xpath="//input[@id='Address']")
	WebElement EditAddressTextbox;
	
	@FindBy(xpath="//input[@id='POCName']")
	WebElement EditContactPersontTextBox;
	
	Screenshot screenshot=new Screenshot();
	
	/**
	 * @Constructor 
	 * @param driver
	 */
	public CustomerManagement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public Boolean Customer_Management_Click() throws Exception
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CustomerManagement_Menu.click();

		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.CustomerManagementPage)))
			return true;
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}
	
	public Boolean Add_CompanyDetails(String CompanyName, String Email, String MobileNumber,String GSTIN,String State,String  PancardNumber,String ConstitutionBusiness, String Nature_of_Business, String ContactPerson, String address,String Expected) throws Exception
	{
		Boolean res=Customer_Management_Click();
		if(res)
		{		
			Companyname.sendKeys(CompanyName);
			Thread.sleep(1000);
		
			email.sendKeys(Email);
			Thread.sleep(1000);
			
			Mobilenumber.sendKeys(MobileNumber);
		
			GstIN.sendKeys(GSTIN);
			Thread.sleep(2000);
			
			contactPerson.click();
			
			Thread.sleep(3000);
			if(confirmButton.isDisplayed())
			{
				confirmButton.click();
				GstIN.sendKeys(GSTIN);
				Thread.sleep(2000);
			}
			Contactperson.sendKeys(ContactPerson);
	
			Address.sendKeys(address);
		
			CreateButton.click();
			
			if(confirmDialogBox.getText().equalsIgnoreCase("Customer Registered Successfully"))
			{
				confirmButton.click();
				return true;
			}
			else		
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
				return false;
			}
		}
		else		
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}
	
	public Boolean SearchCustomerDetails(String searchValue)
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
	
	public Boolean EditCustomerDetails(String CompanyName, String Nature_of_Business, String ConstitutionBusiness, String address, String DOR,String ContactPerson,String Expected) throws Exception
	{
		Boolean res=Customer_Management_Click();
		
		if(res)
		{
			res=SearchCustomerDetails(CompanyName);
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
					
					EditAddressTextbox.clear();
					EditAddressTextbox.sendKeys(address);
					
					EditContactPersontTextBox.clear();
					EditContactPersontTextBox.sendKeys(ContactPerson);
					
					updateButton.click();
					
					Thread.sleep(2000);
					if(confirmDialogBox.getText().equalsIgnoreCase("Customer Updated Successfully"))
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
	
	public Boolean DeleteCustomerDetails(String companyName)
	{
		Boolean res=false;
		try {
			res = Customer_Management_Click();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(res)
		{
			res=SearchCustomerDetails(companyName);
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
					if(SearchCustomerDetails(companyName))
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
	

		    
	
	        
			
			

			
			
			




