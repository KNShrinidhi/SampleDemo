package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

/**
 * @author KK
 *
 */
public class Login_Page 
{
	/**
	 * All the Elements XPath and Web driver declaration
	 */
	public WebDriver driver;
	
	@FindBy(xpath=".//input[@name='email']")
	public WebElement UsernameTextBox;
	
	@FindBy(xpath=".//input[@name='password']")
	public WebElement PasswordTextBox;
	
	@FindBy(xpath=".//button")
	public WebElement SignInButton;
	
	@FindBy(xpath=".//a[@title='Sign Out']")
	public WebElement SignOutButton;
	
	@FindBy(xpath=".//button[@id='bot2-Msg1']")
	public WebElement yesButton;
	
	@FindBy(xpath=".//span[text()='Dashboard']")
	public WebElement loginSuccessful;

	Screenshot screenshot=new Screenshot();
	
	/**
	 * @param driver
	 */
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean Login(String username, String pwd,String expceted) throws InterruptedException
	{
		System.out.println(expceted);
		UsernameTextBox.clear();
		UsernameTextBox.sendKeys(username);
		Thread.sleep(1000);
		
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(pwd);
		Thread.sleep(1000);
		
		SignInButton.click();
		Thread.sleep(3000);
		
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.SummaryDashboardPage)))
			return true;
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}
	/**
	 * @return
	 */
	public Boolean logout()
	{
		if(SignOutButton.isDisplayed())
		{
			SignOutButton.click();
			if(yesButton.isDisplayed())
			{
				yesButton.click();
				return true;
			}
			else
			return false;
		}
		else
		{
			
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}
}
