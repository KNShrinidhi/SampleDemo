package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class GSTRUploads_Page
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='GSTR Uploads']")
	public WebElement GSTRUploads_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1 Save']")
	public WebElement GSTR1Save_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1 View']")
	public WebElement GSTR1View_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1 File']")
	public WebElement GSTR1File_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR2 Save']")
	public WebElement GSTR2Save_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR2 View']")
	public WebElement GSTR2View_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR2 File']")
	public WebElement GSTR2File_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1A Save']")
	public WebElement GSTR1ASave_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR1A File']")
	public WebElement GSTR1AFile_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR3 Save']")
	public WebElement GSTR3Save_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR3 File']")
	public WebElement GSTR3File_Menu;
	
	@FindBy(xpath=".//input[@name='period']")
	public WebElement PeriodTextBox;
	
	@FindBy(xpath=".//select[@id='ddlGSTINNo']")
	public WebElement GSTINDropDown;
	
	@FindBy(xpath=".//select[@id='ddlActionType']")
	public WebElement ActionType;
	
	@FindBy(xpath=".//button[@name='GSTR1Save']")
	public WebElement GSTR1SaveButton;
	
	@FindBy(xpath=".//input[@id='OTP']")
	public WebElement OTPTextBox;
	
	@FindBy(xpath=".//button[@name='OTPSubmit']")
	public WebElement OTPSubmitButton;
	
	Screenshot screenshot=new Screenshot();
	
	public GSTRUploads_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean GSTRUpload_menuClick()
	{
		if((driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1SavePage))) || (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1ViewPage)))
				|| (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1FilePage))) || (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2SavePage)))
				|| (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2FilePage))) || (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1ASavePage)))
				|| (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1AFilePage))) || (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3SavePage)))
				|| (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3FilePage))))
		{
			return true;
		}
		else
		{
			GSTRUploads_Menu.click();
			if(GSTR1Save_Menu.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	public Boolean GSTR1Save_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR1Save_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1SavePage)))
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
	
	public Boolean GSTR1View_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR1View_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1ViewPage)))
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
	
	public Boolean GSTR1File_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR1File_Menu.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1FilePage)))
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
	
	public Boolean GSTR2Save_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR2Save_Menu.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2SavePage)))
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
	
	public Boolean GSTR2File_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR2File_Menu.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR2FilePage)))
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
	
	public Boolean GSTR3Save_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR3Save_Menu.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3SavePage)))
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
	
	public Boolean GSTR3File_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR3File_Menu.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3FilePage)))
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
	
	public Boolean GSTR1ASave_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR1ASave_Menu.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1ASavePage)))
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
	
	public Boolean GSTR1AFile_MenuClick()
	{
		Boolean res= GSTRUpload_menuClick();
		
		if(res)
		{
			GSTR1AFile_Menu.click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1AFilePage)))
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
}
