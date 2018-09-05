package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class GSTR3B_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='GSTR3B']")
	public WebElement GSTR3B_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR 3B Save']")
	public WebElement GSTR3BSave_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR3B Download']")
	public WebElement GSTR3BDownload_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR3B Dashboard']")
	public WebElement GSTR3BDashboard_Menu;
	
	@FindBy(xpath=".//a/span[text()='GSTR3B Report']")
	public WebElement GSTR3BReport_Menu;
	
	
	Screenshot screenshot=new Screenshot();
	
	public GSTR3B_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean GSTR3B_MenuClick()
	{
		if(GSTR3BSave_Menu.isDisplayed())
		{
			return true;
		}
		else
		{
			GSTR3B_Menu.click();
			return true;
		}
		
	}
	public Boolean GSTR3BSave_MenuClick()
	{
		Boolean res= GSTR3B_MenuClick();
		
		if(res)
		{
			GSTR3BSave_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3BSavePage)))
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
	
	public Boolean GSTR3BDownload_MenuClick()
	{
		Boolean res= GSTR3B_MenuClick();
		
		if(res)
		{
			GSTR3BDownload_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3BDownloadPage)))
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
	
	public Boolean GSTR3BDashboard_MenuClick()
	{
		Boolean res= GSTR3B_MenuClick();
		
		if(res)
		{
			GSTR3BDashboard_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3BDashboardPage)))
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
	
	public Boolean GSTR3BReport_MenuClick()
	{
		Boolean res= GSTR3B_MenuClick();
		
		if(res)
		{
			GSTR3BReport_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR3BReportPage)))
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
