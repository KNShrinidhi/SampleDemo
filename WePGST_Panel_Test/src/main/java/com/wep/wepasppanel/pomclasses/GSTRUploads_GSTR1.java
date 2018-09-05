package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath=".//select[@id='ddlGSTR']")
	public WebElement GSTRTypeDropDown;
	
	@FindBy(xpath=".//button[@name='GSTR1Save']")
	public WebElement GSTR1SaveButton;
	
	@FindBy(xpath=".//input[@id='OTP']")
	public WebElement OTPTextBox;
	
	@FindBy(xpath=".//button[@name='OTPSubmit']")
	public WebElement OTPSubmitButton;
	
	@FindBy(xpath=".//p[@class='lead text-muted ']")
	public WebElement confirmDialogBox;
	
	@FindBy(xpath=".//button[@class='confirm btn btn-lg btn-primary']")
	public WebElement buttonOnPopup;
	
	@FindBy(xpath=".//label[@class='input']/i")
	public WebElement calenderIcon;
	
	Screenshot screenshot=new Screenshot();
	
	public GSTRUploads_GSTR1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		gstrupload=new GSTRUploads_Page(driver);
	}
	public Boolean GSTR1Save(String Period, String GSTINNo, String GSTRType, String Action)
	{
		Boolean flag=false;
		Boolean res=gstrupload.GSTR1Save_MenuClick();
		if(res)
		{
			PeriodTextBox.clear();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PeriodTextBox.sendKeys(Period);
			PeriodTextBox.sendKeys(Keys.ESCAPE);
			PeriodTextBox.sendKeys(Keys.ESCAPE);
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Select GSTINList=new Select(GSTINDropDown);
			GSTINList.selectByVisibleText(GSTINNo);
			
			if(!(GSTINList.getFirstSelectedOption().toString().equalsIgnoreCase(GSTINNo)))
			{
				GSTINList.selectByVisibleText(GSTINNo);
			}
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().activeElement();
			if(OTPTextBox.isDisplayed())
			{
				OTPAuthentication();
			}
			
			Select GSTRTypeList=new Select(GSTRTypeDropDown);
			GSTRTypeList.selectByVisibleText(GSTRType);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.switchTo().activeElement();
			if(OTPTextBox.isDisplayed())
			{
				OTPAuthentication();
			}
			
			Select ActionList=new Select(ActionType);
			ActionList.selectByVisibleText(Action);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.switchTo().activeElement();
			if(OTPTextBox.isDisplayed())
			{
				OTPAuthentication();
			}
			
			GSTR1SaveButton.click();
			
//			try {
//				Thread.sleep(15000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			WebDriverWait wait=new WebDriverWait(driver, 6000);
			confirmDialogBox=wait.until(ExpectedConditions.visibilityOf(confirmDialogBox));
			
			if(confirmDialogBox.isDisplayed())
			{
				if(confirmDialogBox.getText().contains("GSTR1 Save is in Progress... Reference Id - "))
				{
					buttonOnPopup.click();
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
	
	public boolean OTPAuthentication()
	{
		driver.switchTo().activeElement();
		if(OTPTextBox.isDisplayed())
		{
			OTPTextBox.click();
			OTPTextBox.sendKeys("575757");
			
			OTPSubmitButton.click();
			if(driver.switchTo().alert().getText().equalsIgnoreCase("Authenticated Successfully"))
			{
				driver.switchTo().alert().accept();
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
