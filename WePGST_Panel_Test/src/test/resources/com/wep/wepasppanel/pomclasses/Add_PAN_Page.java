package com.wep.wepasppanel.pomclasses;

import java.io.IOException;
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
 * @author KK
 *
 */
public class Add_PAN_Page 
{
	/**
	 * All WebElement's XPath and Web driver declaration
	 */
	public WebDriver driver;
	
	@FindBy(xpath=".//span[text()='Add PAN No.']")
	public WebElement PANMenu;
	
	@FindBy(xpath=".//h2[text()='PAN Registration ']")
	public WebElement PANPage;
	
	@FindBy(xpath=".//input[@id='pan']")
	public WebElement PANNUmber_TB;
	
	@FindBy(xpath=".//input[@id='companyname']")
	public WebElement CompanyName_TB;
	
	@FindBy(xpath=".//input[@id='File1']")
	public WebElement PANDoc_TB;
	
	@FindBy(xpath=".//input[@id='File2']")
	public WebElement GSTINDoc_TB;
	
	@FindBy(xpath=".//input[@id='File3']")
	public WebElement POADoc_TB;
	
	@FindBy(xpath=".//form[@id='smart-form-register']//button")
	public WebElement createButton;
	
	@FindBy(xpath=".//input[@type='search']")
	public WebElement searchText;
	
//	@FindBy(xpath=".//button/span[@class='glyphicon glyphicon-search']")
//	public WebElement searchButton;
	
	@FindBy(xpath=".//table[@id='example']/tbody/tr")
	public List<WebElement> resultList;
	
	@FindBy(xpath=".//table[@id='example']/tbody/tr[1]/td[1]")
	public List<WebElement> resultCell;
	
	@FindBy(xpath=".//p[@class='lead text-muted ']")
	public WebElement confirmDialogBox;
	
	@FindBy(xpath=".//input[@id='Edit']")
	public WebElement editButton;
	
	@FindBy(xpath=".//button[@class='confirm btn btn-lg btn-danger']")
	public WebElement buttonOnPopup;
	
	@FindBy(xpath=".//input[@name='files1']")
	public WebElement Edit_PANDoc_TB;
	
	@FindBy(xpath=".//input[@name='files2']")
	public WebElement Edit_GSTINDoc_TB;
	
	@FindBy(xpath=".//input[@name='files3']")
	public WebElement Edit_POADoc_TB;
	
	@FindBy(xpath=".//input[@id='Delete']")
	public WebElement deleteButton;
	
	@FindBy(xpath=".//footer/button")
	public WebElement updateButton;
	
	Screenshot screenshot=new Screenshot();
	
	/**
	 * @param driver
	 */
	public Add_PAN_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/**
	 * @return
	 */
	public Boolean PAN_Menu_Click()
	{
		PANMenu.click();
//		if(PANPage.isDisplayed())
//			return true;
//		else
//			return false;
		
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.AddPANPagePage)))
			return true;
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
			
		
	}
	
	/**
	 * @param PANNo
	 * @param CompName
	 * @param PANDoc
	 * @param GSTNDoc
	 * @param POADoc
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean addPANNumber(String PANNo, String CompName,String PANDoc, String GSTNDoc, String POADoc,String Expected) throws Exception, InterruptedException
	{
		Thread.sleep(3000);
		Boolean res=PAN_Menu_Click();
		if(res)
		{
			PANNUmber_TB.clear();
			PANNUmber_TB.sendKeys(PANNo);
			Thread.sleep(3000);
			CompanyName_TB.clear();
			CompanyName_TB.sendKeys(CompName);
			Thread.sleep(3000);
		/*	PANDoc_TB.click();
			PANDoc_TB.click();
			Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\Wepgst_portal\\testdata\\Docs\\GSTINDoc.exe");
			Thread.sleep(3000);
			GSTINDoc_TB.click();
			GSTINDoc_TB.click();
			Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\Wepgst_portal\\testdata\\Docs\\PanDocUpload.exe");
			Thread.sleep(3000);
					
			POADoc_TB.click();
			POADoc_TB.click();
			Runtime.getRuntime().exec("C:\\Users\\sh\\workspace\\Wepgst_portal\\testdata\\Docs\\GSTINDocPOADocUpload.exe");
				Thread.sleep(3000);*/
			
			if(!PANDoc.isEmpty())
				PANDoc_TB.sendKeys(PANDoc);
			
			if(!GSTNDoc.isEmpty())
				GSTINDoc_TB.sendKeys(GSTNDoc);
			
			if(!POADoc.isEmpty())
				POADoc_TB.sendKeys(POADoc);
			
			createButton.click();
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.alertIsPresent());
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equalsIgnoreCase("PAN details saved Successfully"))
				{
					driver.switchTo().alert().accept();
					return true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
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
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
				
	}
	
	/**
	 * @param searchType
	 * @param searchValue
	 * @return
	 * @throws InterruptedException
	 */
	public Boolean searchPANNumber(String searchType, String searchValue) throws InterruptedException
	{
//		Select searchTypeDropDown=new Select(this.searchType);
//		searchTypeDropDown.selectByVisibleText(searchType);
//		
//		Thread.sleep(2000);
		
		searchText.clear();
		Thread.sleep(3000);	
		searchText.sendKeys(searchValue);
		
		Thread.sleep(3000);		
		//searchButton.click();
		
		if(resultList.size()==1 & !(resultCell.get(0).getText().equalsIgnoreCase("No matching records found")))
			return true;
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
			
		
	}
	
	/**
	 * @param editBy
	 * @param PANNumber
	 * @param companyName
	 * @param PANDoc
	 * @param GSTNDoc
	 * @param POADoc
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Boolean editPANNumber(String editBy,String PANNumber, String companyName,String PANDoc, String GSTNDoc, String POADoc,String Expected) throws IOException, InterruptedException
	{
		Boolean res=PAN_Menu_Click();
		if(res)
		{
			res=searchPANNumber("PAN", editBy);
			
			if(res)
			{
				editButton.click();
				Thread.sleep(1000);
				if(confirmDialogBox.getText().equalsIgnoreCase("Are you sure that you want to Edit this Record?"))
				{
					buttonOnPopup.click();
					
					Thread.sleep(2000);
					
					PANNUmber_TB.clear();
					driver.switchTo().alert().accept();
					Thread.sleep(3000);
					PANNUmber_TB.sendKeys(PANNumber);
					
					Thread.sleep(2000);
					CompanyName_TB.clear();
					CompanyName_TB.sendKeys(companyName);
					
					if(!PANDoc.isEmpty())
						Edit_PANDoc_TB.sendKeys(PANDoc);
					
					if(!GSTNDoc.isEmpty())
						Edit_GSTINDoc_TB.sendKeys(GSTNDoc);
					
					if(!POADoc.isEmpty())
						Edit_POADoc_TB.sendKeys(POADoc);
					
					updateButton.click();
					
					Thread.sleep(2000);
					
					if(driver.switchTo().alert().getText().equalsIgnoreCase("PAN Updated Successfully"))
					{
						driver.switchTo().alert().accept();
						return true;
					}
					else
					{
						screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
						driver.switchTo().alert().accept();
						return false;
					}
						
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
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
			
	}
	
	/**
	 * @param PAN_Number
	 * @return
	 * @throws InterruptedException
	 */
	public boolean delete_PAN_Details(String PAN_Number) throws InterruptedException
	{
		Boolean res=PAN_Menu_Click();
			if(res)
			{
				res=searchPANNumber("PAN", PAN_Number);
				
				if(res)
				{
					deleteButton.click();
					Thread.sleep(1000);
					if(confirmDialogBox.getText().equalsIgnoreCase("Are you sure that you want to delete this Record?"))
					{
						buttonOnPopup.click();
						
						Thread.sleep(2000);
						
//						if(confirmDialogBox.getText().contains("Deleted Successfully"))
//						{
//							driver.switchTo().alert().accept();
//							return true;
//						}
//						else
//						{
//							screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
//							return false;
//						}
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
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
	}
}
