package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wep.wepasppanel.constants.CommonFunctions;
import com.wep.wepasppanel.constants.Screenshot;

public class GSTRUploads_GSTR1 
{
	public WebDriver driver;
	
	public GSTRUploads_Page gstrupload;
	
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
	
	public GSTRUploads_GSTR1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		gstrupload=new GSTRUploads_Page(driver);
	}
	
	
	public Boolean GSTR1Save(String Period, String GSTINNo, String Action)
	{
		Boolean flag=false;
		Boolean res=gstrupload.GSTR1Save_MenuClick();
		if(res)
		{
			PeriodTextBox.clear();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PeriodTextBox.sendKeys(Period);
			
			Select GSTINList=new Select(GSTINDropDown);
			GSTINList.selectByVisibleText(GSTINNo);
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
			Select ActionList=new Select(ActionType);
			ActionList.selectByVisibleText(Action);
			
			GSTR1SaveButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().contains("GSTR1 Save is in Progress... Reference Id - "))
				{
					flag=true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.navigate().back();
				}
			}
		}
		if(flag==false)
			return false;
		else
			return true;
	}
}
