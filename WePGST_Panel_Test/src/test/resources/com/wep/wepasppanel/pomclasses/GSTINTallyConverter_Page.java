package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class GSTINTallyConverter_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//span[text()='GSTN / Tally Converter']")
	public WebElement GSTINTallyConveter_Menu;
	
	@FindBy(xpath=".//span[text()='Convert CSV']")
	public WebElement ConvertCSV_Menu;
	
	@FindBy(xpath=".//span[text()='GSTR Upload']")
	public WebElement GSTRUpload_Menu;
	
	Screenshot screenshot=new Screenshot();
	
	public GSTINTallyConverter_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean GSTINTallyConverter_MenuClick()
	{
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ConvertCSVPage)))
		{
			return true;
		}
		else
		{
			GSTINTallyConveter_Menu.click();
			if(ConvertCSV_Menu.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	/**
	 * @return
	 */
	public Boolean ConvertCSV_MenuClick()
	{
		Boolean res=GSTINTallyConverter_MenuClick();
		
		if(res)
		{
			ConvertCSV_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ConvertCSVPage)))
			{
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
	
	public Boolean GSTRUpload_MenuClick()
	{
		Boolean res=GSTINTallyConverter_MenuClick();
		
		if(res)
		{
			GSTRUpload_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTRUploadPage)))
			{
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
}
