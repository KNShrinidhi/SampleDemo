package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class EWayBill_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='EWayBill']")
	public WebElement EwayBill_Menu;
	
	@FindBy(xpath=".//li[@class='open']//a[@title='Dashboard']/span[text()='Dashboard']")
	public WebElement EwayBillDashboard_Menu;
	
	@FindBy(xpath=".//a/span[text()='Generate EWayBill']")
	public WebElement EwayBillGeneration_Menu;
	
	@FindBy(xpath=".//a/span[text()='Generate Consolidate EwayBill']")
	public WebElement Cons_EwayBillGeneration_Menu;
	
	@FindBy(xpath=".//a/span[text()='Bulk Upload']")
	public WebElement BulkUpload_Menu;
	
	@FindBy(xpath=".//a/span[text()='Update Vehicle']")
	public WebElement UpdateVehicle_Menu;
	
	@FindBy(xpath=".//a/span[text()='EWayBill List']")
	public WebElement EwayBillList_Menu;
	
	@FindBy(xpath=".//a/span[text()='Cancel / Print']")
	public WebElement EwayBillCancelPrint_Menu;
	
	@FindBy(xpath=".//a/span[text()='Reject']")
	public WebElement EwayBillReject_Menu;
	
	Screenshot screenshot=new Screenshot();
	
	public EWayBill_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean EWayBill_MenuClick()
	{
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillDashboardPage)) || driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillGenerationPage))
				|| driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillListPage)) || driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillCancelPrintPage))
				|| driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillRejectPage)))
		{
			return true;
		}
		else
		{
			EwayBill_Menu.click();
			if(EwayBillGeneration_Menu.isDisplayed())
			{
				return true;
			}
			else
			{
				
				return true;
			}
		}
		
		
	}
	public Boolean EWayBillDashBoard_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			EwayBillDashboard_Menu.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillDashboardPage)))
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
	
	public Boolean EWayBillGeneration_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			EwayBillGeneration_Menu.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillGenerationPage)))
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
	
	public Boolean ConsEWayBillGeneration_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			Cons_EwayBillGeneration_Menu.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ConsEWayBillGenerationPage)))
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
	
	public Boolean BulkUpload_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			BulkUpload_Menu.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.BulkUploadPage)))
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
	
	public Boolean UpdateVehicleNo_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			UpdateVehicle_Menu.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.UpdateVehiclePage)))
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
	
	public Boolean EWayBillList_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			EwayBillList_Menu.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillListPage)))
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
	
	public Boolean EWayBillCancelPrint_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			EwayBillCancelPrint_Menu.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillCancelPrintPage)))
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
	
	public Boolean EWayBillReject_MenuClick()
	{
		Boolean res= EWayBill_MenuClick();
		
		if(res)
		{
			((JavascriptExecutor) driver)
            .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			EwayBillReject_Menu.click();
			System.out.println(driver.getTitle());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EWayBillRejectPage)))
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
