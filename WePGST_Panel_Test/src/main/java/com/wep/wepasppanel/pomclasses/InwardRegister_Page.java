package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class InwardRegister_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='Inward Register']")
	public WebElement InwardRegister_Menu;
	
	@FindBy(xpath=".//a/span[text()='B2B Supplier Invoice']")
	public WebElement B2BSupplierInvoice_Menu;
	
	@FindBy(xpath=".//a/span[text()='Reverse Charge / Unregistered Invoice']")
	public WebElement ReverseChargeInvoice_Menu;
	
	Screenshot screenshot=new Screenshot();
	
	public InwardRegister_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean Inwardregister_MenuClick()
	{
		if(B2BSupplierInvoice_Menu.isDisplayed())
		{
			return true;
		}
		else
		{
			InwardRegister_Menu.click();
			return true;
		}
		
	}
	
	public Boolean B2BSupplierInvoice_MenuClick()
	{
		Boolean res= Inwardregister_MenuClick();
		
		if(res)
		{
			B2BSupplierInvoice_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.B2BSupplierInvoicePage)))
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
	
	public Boolean ReverseChargeInvoice_MenuClick()
	{
		Boolean res= Inwardregister_MenuClick();
		
		if(res)
		{
			ReverseChargeInvoice_Menu.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ReverseChargeUnregisteredInvoicePage)))
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
