package com.wep.wepasppanel.pomclasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Screenshot;
/**
 * 
 * @author Harish Takle
 *
 */
public class CreateAccount {
	
	
	/* All the Elements xpath */
	public WebDriver driver;
	
	@FindBy(xpath="//*[@class='btn btn-danger']")
	public WebElement CreateAccount;
	
	@FindBy(xpath=".//*[@id='smart-form-register']/div/header")
	public WebElement Registrationpage;
	
	@FindBy(id="name")
	public WebElement CName;
		
	@FindBy(id="designation")
	public WebElement Designation;
			
	@FindBy(id="company")
	public WebElement Company;
			
				
	@FindBy(id="email")
	public WebElement Email;
				
				
	@FindBy(id="mobile")
	public WebElement MobileNumber;
					
	@FindBy(id="Address")
	public WebElement Address;
					
					
	@FindBy(id="gstusername")
	public WebElement GSTusername;
						
	@FindBy(id="gst")
	public WebElement GSTnumber;
	
	@FindBy(id="cgst")
	public WebElement ConfirmGST;
	
	@FindBy(id="pan")
	public WebElement Pannumber;
	
	@FindBy(id="statecode")
	public WebElement StateCode;
	
	
	@FindBy(xpath=".//input[@name='files']")
	public WebElement UploadPANDoc;
	
	@FindBy(xpath=".//input[@name='files1']")
	public WebElement UploadGSTINDoc;
	
	@FindBy(xpath=".//input[@name='files2']")
	public WebElement UploadPOADoc;
		
	@FindBy(xpath=".//*[@id='smart-form-register']/div/fieldset[5]/section[2]/label/i")
	public WebElement ClickonRegisterButton;
	
	@FindBy(id="Register")
	public WebElement Register;
	
	@FindBy(xpath="//*[@class='alert alert-danger alert-block']")
	WebElement Error_Message;
	
	@FindBy(xpath="//*[@class='close']")
	WebElement Error_CloseOption;
	
	@FindBy(xpath="//*[text()='Sign In']")
	WebElement SignIn;		
		
	Screenshot screenshot=new Screenshot();
	
/**
 * @Constructor
 * @param driver
 */
	public CreateAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
	/**
	 * Click on the Customer Registration Page
	 * @return
	 */
	public Boolean Customer_Registration_Click()
	{
		CreateAccount.click();
		if(Registrationpage.isDisplayed())
			return true;
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
			
		
	}
	
	/**
	 * Enter the Details of the Customer 
	 * @param cname
	 * @param designation
	 * @param compname
	 * @param email
	 * @param mobilenumber
	 * @param Compaddress
	 * @param GSTname
	 * @param GSTNo
	 * @param CGSTNo
	 * @param Pancard
	 * @param state
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean Customerregistration(String cname,String designation,String compname,String email,String mobilenumber,String Compaddress,String GSTname,String GSTNo, String CGSTNo) throws IOException,InterruptedException
	
	{ 
		Boolean res=Customer_Registration_Click();
	 
	if(res)
	{
		CName.clear();
		CName.sendKeys(cname);
		Thread.sleep(1000);
		
		Designation.clear();
		Designation.sendKeys(designation);
		Thread.sleep(1000);
		
		Company.clear();
		Company.sendKeys(compname);
		Thread.sleep(1000);
		
		Email.clear();
		Email.sendKeys(email);
		Thread.sleep(1000);
		
		MobileNumber.clear();
		MobileNumber.sendKeys(mobilenumber);
		Thread.sleep(1000);
		
		Address.clear();
		Address.sendKeys(Compaddress);
		Thread.sleep(1000);
		
		GSTusername.clear();
		GSTusername.sendKeys(GSTname);
		Thread.sleep(1000);
		
		GSTnumber.clear();
		GSTnumber.sendKeys(GSTNo);
		Thread.sleep(1000);
		
		ConfirmGST.clear();
		ConfirmGST.sendKeys(CGSTNo);
		Thread.sleep(1000);
		
		
		/**
		 * Uploading Files using autoIT
		 */
		UploadPANDoc.click();
		UploadPANDoc.click();
		Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\Wepgst_portal\\testdata\\GSTINDocUpload.exe");
		Thread.sleep(2000);
		
		UploadGSTINDoc.click();
		UploadGSTINDoc.click();
		Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\Wepgst_portal\\testdata\\PanDocUpload.exe");
		Thread.sleep(2000);
		
		UploadPOADoc.click();
		UploadPOADoc.click();
		Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\Wepgst_portal\\testdata\\POADocUpload.exe");
		Thread.sleep(2000);
		
		
		ClickonRegisterButton.click();
		Thread.sleep(1000);
		
		Register.click();
		Thread.sleep(2000);
		
		
		
		
	
		String actualError=Error_Message.getText();
		System.out.println(actualError);
	    String expectedError="GSTIN or Email ID or Mobile Number of this Customer already exists";
		
		if(actualError.equals(expectedError))
		
		{
			return true;
		}
		else
		{
			Thread.sleep(1000);
			Error_CloseOption.click();
			Thread.sleep(1000);
			SignIn.click();	
			
			
			
		
		}
		
		
	
	
		
		
	

	}
	

	else
	{
		screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		return false;
	
	}
	return res;

	
	}
}

	
		
	
	

