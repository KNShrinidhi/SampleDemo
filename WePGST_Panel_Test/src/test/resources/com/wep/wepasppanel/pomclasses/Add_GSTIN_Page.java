package com.wep.wepasppanel.pomclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wep.wepasppanel.constants.CommonFunctions;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

/**
 * @author Krishnamurthy Karanth 30.11.2017
 *
 */
public class Add_GSTIN_Page 
{
	/**
	 * All WebElement's XPath and WebDriver Declaration
	 */
	public WebDriver driver;
	
	
	@FindBy(xpath=".//span[text()='Add GSTIN']")
	public WebElement AddGSTNMenu;
	
	@FindBy(xpath=".//h2[text()='GSTIN Registration ']")
	public WebElement GSTNPage;
	
	@FindBy(xpath=".//*[@id='gstusername']")
	public WebElement GSTNUsername;
	
	@FindBy(xpath=".//*[@id='gst']")
	public WebElement GSTNNumber;
	
	@FindBy(xpath=".//*[@id='address']")
	public WebElement Address_TextBox;
	
	@FindBy(xpath=".//*[@id='smart-form-register']/footer/section/button")
	public WebElement createButton;
	
//	@FindBy(xpath="//input[@type='search']")
//	public WebElement search_DropDown;
	
	@FindBy(xpath=".//input[@type='search']")
	public WebElement searchTextBox;
	
//	@FindBy(xpath=".//button/span[@class='glyphicon glyphicon-search']")
//	public WebElement searchButton;
	
	@FindBy(xpath=".//table[@id='example']/tbody/tr")
	public List<WebElement> resultList;
	
	@FindBy(xpath=".//table[@id='example']/tbody/tr[1]/td[1]")
	public List<WebElement> resultCell;
	
	@FindBy(xpath=".//input[@id='Delete']")
	public WebElement deleteButton;
	
	@FindBy(xpath=".//input[@id='Edit']")
	public WebElement editButton;
	
	@FindBy(xpath=".//p[@class='lead text-muted ']")
	public WebElement confirmDialogBox;
	
	@FindBy(xpath=".//footer/button")
	public WebElement updateButton;
	
	@FindBy(xpath=".//button[@class='confirm btn btn-lg btn-danger']")
	public WebElement buttonOnPopup;
	
	@FindBy(xpath=".//button[@class='cancel btn btn-lg btn-default']")
	public WebElement cancelOnPopup;
	
	Screenshot screenshot=new Screenshot();
	
	/**
	 * @param driver
	 */
	public Add_GSTIN_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/**
	 * @return
	 * @throws Exception 
	 */
	public Boolean GSTN_Menu_Click() throws InterruptedException
	{
		AddGSTNMenu.click();
		Thread.sleep(3000);
//		if(GSTNPage.isDisplayed())
//			return true;
//		else
//			return false;
		
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.AddGSTINPage)))
			return true;
		else
			return false;
	}
	
	/**
	 * @param GSTNUsername
	 * @param GSTNNo
	 * @param address
	 * @return
	 * @throws Exception 
	 */
	public Boolean Add_GSTN(String GSTNUsername, String GSTNNo, String address,String Expected) throws InterruptedException
	{
		Boolean res=GSTN_Menu_Click();
		
		if(res)
		{
			this.GSTNUsername.clear();
			this.GSTNUsername.sendKeys(GSTNUsername);
			
			GSTNNumber.clear();
			GSTNNumber.sendKeys(GSTNNo);
			
			Address_TextBox.clear();
			Address_TextBox.sendKeys(address);
			
			createButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equalsIgnoreCase("GSTIN Registered Successfully"))
				{
					driver.switchTo().alert().accept();
					
					return true;
				}
				else
				{
					driver.switchTo().alert().accept();
					return false;
				}
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
			return false;
		}
	}
	
	/**
	 * @param Search_By
	 * @param Search_Value
	 * @return
	 * @throws InterruptedException
	 */
	public boolean search(String Search_By, String Search_Value) throws InterruptedException
	{
//		Select searchTypeDropDown=new Select(search_DropDown);
//		searchTypeDropDown.selectByVisibleText(Search_By);
		searchTextBox.clear();
		searchTextBox.sendKeys(Search_Value);
		Thread.sleep(2000);
		
//		searchTextBox.clear();
//		Thread.sleep(3000);	
//		searchTextBox.sendKeys(Search_Value);
//		
		Thread.sleep(3000);		
//		searchButton.click();
		
		
		if(resultList.size()==1 & !(resultCell.get(0).getText().equalsIgnoreCase("No matching records found")))
			return true;
		else
			return false;
		
	}
	/**
	 * @param Gstn_To_Be_Edited
	 * @param Username
	 * @param GSTN_No
	 * @param Address
	 * @return
	 * @throws InterruptedException
	 */
	public Boolean edit_GSTN_Details(String Gstn_To_Be_Edited, String  Username, String GSTN_No, String  Address,String Expected) throws InterruptedException
	{
		Boolean res=GSTN_Menu_Click();
		
		if(res)
		{
			res=search("GSTIN", Gstn_To_Be_Edited);
			if(res)
			{
				editButton.click();
				
				Thread.sleep(2000);
				if(confirmDialogBox.getText().equalsIgnoreCase("Are you sure that you want to Edit this Record?"))
				{
					buttonOnPopup.click();
					
					Thread.sleep(2000);
					
					GSTNUsername.clear();
					GSTNUsername.sendKeys(Username);
					
					Address_TextBox.clear();
					Address_TextBox.sendKeys(Address);
					
					updateButton.click();
					
					if(driver.switchTo().alert().getText().equalsIgnoreCase("GSTIN updated Successfully"))
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
			else
				return false;
		}
		else
			return false;
		
	}
	
	/**
	 * @param Gstn_To_Be_Edited
	 * @return
	 * @throws InterruptedException
	 */
	public Boolean delete_GSTN_Details(String Gstn_To_Be_Edited) throws InterruptedException
	{
		Boolean res=GSTN_Menu_Click();
		
		if(res)
		{
			res=search("GSTIN", Gstn_To_Be_Edited);
			if(res)
			{
				deleteButton.click();
				
				Thread.sleep(4000);
				if(confirmDialogBox.getText().equalsIgnoreCase("Are you sure that you want to delete this Record?"))
				{
					buttonOnPopup.click();
					return true;
					
//					Thread.sleep(2000);
//					if(driver.switchTo().alert().getText().contains("GSTIN Deleted Successfully"))
//					{
//						driver.switchTo().alert().accept();
//						return true;
//					}
//					else
//						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}	
	
	
}
