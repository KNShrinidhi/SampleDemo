package com.wep.wepasppanel.pomclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.wep.wepasppanel.constants.CommonFunctions;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

/**
 * @author KK
 *
 */
public class UploadInformation_Page 
{
	/**
	 * All Web elements declaration and driver declaration
	 */
	public WebDriver driver;
	
	@FindBy(xpath=".//span[text()='Upload Information']")
	public WebElement Upload_Information_Menu;
	
	@FindBy(xpath=".//span[text()='GSTR CSV Upload']")
	public WebElement GSTR_CSV_Upload_Menu;
	
	@FindBy(xpath=".//span[text()='GSTIN Validation']")
	public WebElement GSTINValidation_Menu;
	
	@FindBy(xpath=".//span[text()='Device Upload']")
	public WebElement DeviceUpload_Menu;
	
	@FindBy(xpath=".//select[@id='ddlGSTR']")
	public WebElement GSTR_DropDown;
	
	@FindBy(xpath=".//input[@id='FileUpload']")
	public WebElement ChooseFile_Button;
	
	@FindBy(xpath=".//button[@value='Import']")
	public WebElement Import_Data_Button;
	
	@FindBy(xpath=".//h2[text()='GSTR CSV Uploads']")
	public WebElement CSVUpload_PageTitle;
	
	@FindBy(xpath=".//footer/div/section")
	public List<WebElement> Processed_Count;
	
	@FindBy(xpath=".//footer/div/section/a")
	public WebElement Error_Count;
	
	@FindBy(xpath=".//button[@value='GSTRUpload']")
	public WebElement GSTRUpload_Button;
	
	Screenshot screenshot=new Screenshot();
	
	public UploadInformation_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/**
	 * @return
	 */
	public Boolean Upload_Information_Master_Menu_Click()
	{
		if(!(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTRCSVUploadPage)) || (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.DeviceUploadPage))) || (driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTINValidationPage)))))
		{
			Upload_Information_Menu.click();
			return true;
		}
		else if(GSTR_CSV_Upload_Menu.isDisplayed())
		{
			return true;
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	}
	
	/**
	 * @return
	 * @throws InterruptedException 
	 */
	public Boolean GSTR_CSV_Upload_Menu() 
	{
		Boolean res=Upload_Information_Master_Menu_Click();
		
		if(res)
		{
			GSTR_CSV_Upload_Menu.click();
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTRCSVUploadPage)))
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
	
	public Boolean GSTINValidation_MenuClick()
	{
		Boolean res=Upload_Information_Master_Menu_Click();
		
		if(res)
		{
			GSTINValidation_Menu.click();
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTINValidationPage)))
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
	
	public Boolean DeviceUpload_MenuClick()
	{
		Boolean res=Upload_Information_Master_Menu_Click();
		
		if(res)
		{
			DeviceUpload_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.DeviceUploadPage)))
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
	
	/**
	 * @param GSTR_Type
	 * @param Action
	 * @param File_path
	 * @return
	 * @throws Exception 
	 */
	public boolean Import_CSV_File(String GSTR_Type, String Action, String File_path) throws Exception
	{
//		String File_path=LoadConstantsData.readData(Constants.GeneralPath)+LoadConstantsData.readData(Constants.CSVfilesPath)+File_name;
		System.out.println(File_path);
		Boolean res=GSTR_CSV_Upload_Menu();
		Boolean flag=false;
		if(res)
		{
			Select GSTR_Drop_Down=new Select(GSTR_DropDown);
			GSTR_Drop_Down.selectByVisibleText(GSTR_Type);
			
			ChooseFile_Button.sendKeys(File_path);
			
			Import_Data_Button.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().contains("GSTR CSV File imported successfully..."))
				{
					driver.switchTo().alert().accept();
					Thread.sleep(3000);
					res=Error_Count_Checking();
					if(res)
					{
						GSTRUpload_Button.click();
						if(CommonFunctions.isAlertPresent(driver))
						{
							if(driver.switchTo().alert().getText().equalsIgnoreCase("Data Uploaded Successfully"))
							{
								driver.switchTo().alert().accept();
								flag=true;
							}
							else
							{
								screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
							}
						}
						else
						{
							screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
						}
					}
					else
					{
						screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					}
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.switchTo().alert().accept();
				}
			}
		}
		if(flag==false)
			return flag;
		else
			return true;
	}
	
	/**
	 * @return
	 */
	public boolean Error_Count_Checking()
	{
		String[] totalRecords=Processed_Count.get(0).getText().split(":", 0);
		String[] totalProcessedRecords=Processed_Count.get(1).getText().split(":", 0);
		
		if(totalRecords[1].equalsIgnoreCase(totalProcessedRecords[1]))
		{
			return true;
		}
		else if(!(Processed_Count.get(0).getText().equalsIgnoreCase("Total Records count: 0")) && (Error_Count.getText().equalsIgnoreCase("Total Error Records count: 0")))
		{
			Error_Count.click();
			return false;
		}
			
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
		
	}
}
