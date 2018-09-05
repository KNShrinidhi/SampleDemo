package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class Reconciliation_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='Reconciliation']")
	public WebElement ReconciliationMaster_Menu;
	
	@FindBy(xpath=".//a/span[text()='Invoice Data Correction']")
	public WebElement InvoiceDataCorrection_Menu;
	
	@FindBy(xpath=".//a/span[text()='Invoice Value Correction']")
	public WebElement InvoiceValueCorrection_Menu;
	
	@FindBy(xpath=".//a/span[text()='Reconcilation Settings']")
	public WebElement ReconcilationSettings_Menu;
	
	@FindBy(xpath=".//li[4]/a[@title='Reconciliation']/span[text()='Reconciliation']")
	public WebElement Reconciliation_Menu;
	
	@FindBy(xpath=".//a/span[text()='Update ITC']")
	public WebElement UpdateITC_Menu;
	
	Screenshot screenshot=new Screenshot();
	
	public Reconciliation_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean ReconciliationMaster_MenuClick()
	{
		if(ReconcilationSettings_Menu.isDisplayed())
		{
			return true;
		}
		else
		{
			ReconciliationMaster_Menu.click();
			return true;
		}
		
	}
	
	public Boolean InvoiceDataCorrection_MenuClick()
	{
		Boolean res= ReconciliationMaster_MenuClick();
		
		if(res)
		{
			InvoiceDataCorrection_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.InvoiceDataCorrectionPage)))
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
	
	public Boolean InvoiceValueCorrection_MenuClick()
	{
		Boolean res= ReconciliationMaster_MenuClick();
		
		if(res)
		{
			InvoiceValueCorrection_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.InvoiceValueCorrectionPage)))
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
	
	public Boolean ReconciliationSetting_MenuClick()
	{
		Boolean res= ReconciliationMaster_MenuClick();
		
		if(res)
		{
			ReconcilationSettings_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ReconcilationSettingsPage)))
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
	
	public Boolean Reconciliation_MenuClick()
	{
		Boolean res= ReconciliationMaster_MenuClick();
		
		if(res)
		{
			Reconciliation_Menu.click();
			System.out.println(driver.getTitle());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ReconciliationPage)))
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
	
	public Boolean UpdateITC_MenuClick()
	{
		Boolean res= ReconciliationMaster_MenuClick();
		
		if(res)
		{
			UpdateITC_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.UpdateITCPage)))
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
