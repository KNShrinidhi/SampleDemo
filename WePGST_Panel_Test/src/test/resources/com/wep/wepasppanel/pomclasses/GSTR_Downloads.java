package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wep.wepasppanel.constants.CommonFunctions;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class GSTR_Downloads 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='GSTR Downloads']")
	public WebElement GSTRDownload_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1 Download']")
	public WebElement GSTR1Download_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR2A Download']")
	public WebElement GSTR2ADownload_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR2 Download']")
	public WebElement GSTR2Download_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1A Download']")
	public WebElement GSTR1ADownload_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR3 Download']")
	public WebElement GSTR3Download_Menu;
	
	@FindBy(xpath=".//a/span[text()='Track Filing Status']")
	public WebElement TrackStatus_Menu;
	
	@FindBy(xpath=".//input[@name='period']")
	public WebElement PeriodTextBox;
	
	@FindBy(xpath=".//select[@id='gstin']")
	public WebElement GSTINDropDown;
	
	@FindBy(xpath=".//select[@id='action']")
	public WebElement ActionType;
	
	@FindBy(xpath=".//input[@name='refid']")
	public WebElement ReferenceIdTextBox;
	
	@FindBy(xpath=".//button[@id='Download']")
	public WebElement DownloadButton;
	
	@FindBy(xpath=".//button[@id='Export']")
	public WebElement ExportButton;
	
	@FindBy(xpath=".//select[@id='ctin']")
	public WebElement CTINDropDown;
	
	@FindBy(xpath=".//input[@name='statecode']")
	public WebElement StateCodeTextBox;
	
	@FindBy(xpath=".//input[@id='OTP']")
	public WebElement OTPTextBox;
	
	@FindBy(xpath=".//button[@name='OTPSubmit']")
	public WebElement OTPSubmitButton;
	
	@FindBy(xpath=".//div[@class='table-responsive']")
	public WebElement resultArea;
	
	Screenshot screenshot=new Screenshot();
	
	public GSTR_Downloads(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean GSTRDownload_menuClick()
	{
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1DownloadPage)) || driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2ADownloadPage)) || driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2DownloadPage))
				|| driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1ADownloadPage)) || driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3DownloadPage)) || driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.TrackFilingStatusPage)))
		{
			return true;
		}
		else 
		{
			GSTRDownload_Menu.click();
			if(GSTR1Download_Menu.isDisplayed())
			{
				return true;
			}
			else
			{
				return true;
			}
		}
		
		
	}
	public Boolean GSTR1Download_MenuClick()
	{
		Boolean res= GSTRDownload_menuClick();
		
		if(res)
		{
			GSTR1Download_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1DownloadPage)))
			{
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
	
	public Boolean GSTR2ADownload_MenuClick()
	{
		Boolean res= GSTRDownload_menuClick();
		
		if(res)
		{
			GSTR2ADownload_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2ADownloadPage)))
			{
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
	
	public Boolean GSTR2Download_MenuClick()
	{
		Boolean res= GSTRDownload_menuClick();
		
		if(res)
		{
			GSTR2Download_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2DownloadPage)))
			{
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
	
	public Boolean GSTR3Download_MenuClick()
	{
		Boolean res= GSTRDownload_menuClick();
		
		if(res)
		{
			GSTR3Download_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3DownloadPage)))
			{
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
	
	public Boolean GSTR1ADownload_MenuClick()
	{
		Boolean res= GSTRDownload_menuClick();
		
		if(res)
		{
			GSTR1ADownload_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1ADownloadPage)))
			{
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
	
	public Boolean TrackStatus_MenuClick()
	{
		Boolean res= GSTRDownload_menuClick();
		
		if(res)
		{
			TrackStatus_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.TrackFilingStatusPage)))
			{
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
	
	public Boolean GSTR1_Download(String GSTINNo, String Period, String Action, String ReferenceId)
	{
		Boolean flag=false;
		Boolean res=GSTR1Download_MenuClick();
		if(res)
		{
			Select GSTINDropDownList=new Select(GSTINDropDown);
			GSTINDropDownList.selectByVisibleText(GSTINNo);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().activeElement();
			if(OTPTextBox.isDisplayed())
			{
				OTPTextBox.click();
				OTPTextBox.sendKeys("575757");
				
				OTPSubmitButton.click();
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Authenticated Successfully"))
				{
					driver.switchTo().alert().accept();
				}
				
			}
			
			PeriodTextBox.clear();
			PeriodTextBox.sendKeys(Period);
			
			Select ActionList=new Select(ActionType);
			ActionList.selectByVisibleText(Action);
			
			switch(Action)
			{
				case "B2B": 
					Select CustomerGSTINList=new Select(CTINDropDown);
					CustomerGSTINList.selectByVisibleText(ReferenceId);
					break;
					
				case "B2CL": 
					StateCodeTextBox.clear();
					StateCodeTextBox.sendKeys(ReferenceId);
					break;
				
				case "B2CS": 
					StateCodeTextBox.clear();
					StateCodeTextBox.sendKeys(ReferenceId);
					break;
					
				case "RETSTATUS": 
					ReferenceIdTextBox.clear();
					ReferenceIdTextBox.sendKeys(ReferenceId);
					break;
					
			}
			
			DownloadButton.click();
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().contains(" Error Code :") || driver.switchTo().alert().getText().contains("Successfully"))
				{
					driver.switchTo().alert().accept();
//					String result=resultArea.getText();
					flag=true;
					//if(result.contains(" \"status_cd\": \"P\""))
						
				}
			}
		}
		
		return flag;
		
	}
}
