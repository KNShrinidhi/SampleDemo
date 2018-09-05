package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

public class DownloadDocuments_Page 
{
	public WebDriver driver;
	
	@FindBy(xpath=".//a/span[text()='Download Documents']")
	public WebElement DownloadDocument_Menu;
	
	Screenshot screenshot=new Screenshot();
	
	public DownloadDocuments_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean DownloadDocuments_menuClick()
	{
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.DownloadDocumentsPage)))
		{
			return true;
		}
		else
		{
			DownloadDocument_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.DownloadDocumentsPage)))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
}
