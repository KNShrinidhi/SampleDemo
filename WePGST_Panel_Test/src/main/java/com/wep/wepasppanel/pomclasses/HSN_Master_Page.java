package com.wep.wepasppanel.pomclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

/**
 * @author KK
 *
 */
public class HSN_Master_Page
{
/**
 * All Web Elements XPATH and Web Driver declaration
 */
public WebDriver driver;
	
	/**
	 * @param driver
	 */
	public HSN_Master_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//span[text()='HSN Master']")
	WebElement HSN_Master_Menu;
	
	@FindBy(xpath="//*[@title='HSN Rate Finder']")
	WebElement HSN_Rate_Finder_Menu;
	
	@FindBy(xpath="//*[@title='HSN Creation']")
	WebElement HSNCreation_Menu;
	
	@FindBy(xpath=".//h2[text()='HSN Rate Finder']")
	WebElement HSN_Rate_Finder_pageTitle;
	
	@FindBy(xpath=".//h2[text()='HSN Code Creation']")
	WebElement HSN_Creation_pageTitle;
	
	@FindBy(xpath=".//table[@id='hsnfinder']/tbody/tr")
	List<WebElement> HSN_Rate_Finder_resultGrid;
	
	@FindBy(xpath="//*[@id='searchtext']")
	WebElement Search_TextBox;
	
	@FindBy(xpath="//*[@name='hsntype']")
	WebElement HSN_Type_DropDown;
	
	@FindBy(xpath="//*[@value='Yes']")
	WebElement HSN_Entry_From_Database_Radio_Button;
	
	@FindBy(xpath="//*[@value='No']")
	WebElement HSN_Entry_Manual_Radio_Button;
	
	@FindBy(xpath="//*[@name='hsncode']")
	WebElement HSN_Code_DropDpwn;
	
	@FindBy(xpath="//*[@name='hsncode1']")
	WebElement HSN_Code_TextBox;
	
	@FindBy(xpath="//*[@name='hsndesc']")
	WebElement HSN_Desc_DropDown;
	
	@FindBy(xpath="//*[@name='hsndesc1']")
	WebElement HSN_Desc_Text;
	
	@FindBy(xpath="//*[@id='rate']")
	WebElement Rate_TextBox;
	
	@FindBy(xpath="//*[@id='rate1']")
	WebElement Rate_DropDown;
	
	@FindBy(xpath="//button[@class='btn btn-md']//b[text()='Create']")
	WebElement Create_Button;
	
	@FindBy(xpath="//*[@name='FileUpload']")
	WebElement Choose_File_Button;
	
	@FindBy(xpath="//*[@id='btnUpload']")
	WebElement UploadFile_Button;
	
  //Edit HSN Code
	
	@FindBy(xpath=".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr")
	List<WebElement> HSN_List;
	
	@FindBy(xpath="//select[@id='hsncode']")
	WebElement Edit_HSN_Code_TextBox;
	
	@FindBy(xpath="//*[@name='hsnDescription']")
	WebElement Edit_HSN_Desc_TextBox;
	
	@FindBy(xpath="//select[@id='rate']")
	WebElement Edit_Rate;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	WebElement Update_Button;
	
	Screenshot screenshot=new Screenshot();

	//Delete the HSN Code
	@FindBy(xpath="//a[@tooltip='Delete']")
	WebElement Delete_Button;
	
	/**
	 * @return
	 */
	public Boolean HSN_Master_menuClick()
	{
		if(!(HSN_Rate_Finder_Menu.isDisplayed()))
		{
			HSN_Master_Menu.click();
			
			if(HSN_Rate_Finder_Menu.isDisplayed())
				return true;
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				return false;
			}
				
		}
		else
			return true;
		
	}
	
	/**
	 * @return
	 */
	public Boolean HSN_Rate_Finder_menuClick()
	{
		Boolean res=HSN_Master_menuClick();
		if(res)
		{
			HSN_Rate_Finder_Menu.click();
			//if(HSN_Rate_Finder_pageTitle.isDisplayed() || HSN_Rate_Finder_pageTitle.getText().contains("HSN Rate Finder"))
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.HSNRateFinderPage)))
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
	 * @param HSNCode
	 * @return
	 * @throws InterruptedException
	 */
	public Boolean HSN_Rate_Finder_Search(String HSNCode) throws InterruptedException
	{
		
		Boolean res=HSN_Rate_Finder_menuClick();
		if(res)
		{
			Search_TextBox.clear();
			Search_TextBox.sendKeys(HSNCode);
			
			Thread.sleep(2000);
			
			if(HSN_Rate_Finder_resultGrid.size()>1)
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
	 * @return
	 */
	public Boolean HSN_Creation_menuClick()
	{
		Boolean res=HSN_Master_menuClick();
		if(res)
		{
			HSNCreation_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.HSNCreationPage)))
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
	 * @param HSN_Type
	 * @param HSN_Entry
	 * @param HSN_Code
	 * @param HSN_Desc
	 * @param HSN_Rate
	 * @return
	 * @throws InterruptedException
	 */
	public Boolean HSN_Creation(String HSN_Type, String HSN_Entry, String HSN_Code, String HSN_Desc, String HSN_Rate,String Expected) throws InterruptedException
	{
		Boolean res=HSN_Creation_menuClick();
		if(res)
		{
			Select HSN_Type_Drop_Down=new Select(HSN_Type_DropDown);
			HSN_Type_Drop_Down.selectByVisibleText(HSN_Type);
			
			if(HSN_Entry.equalsIgnoreCase("From Database"))
			{
				HSN_Entry_From_Database_Radio_Button.click();
				
				Select HSN_Code_DD=new Select(HSN_Code_DropDpwn);
				HSN_Code_DD.selectByVisibleText(HSN_Code);
				
				Select HSN_Desc_DD=new Select(HSN_Desc_DropDown);
				HSN_Desc_DD.selectByVisibleText(HSN_Desc);
				
				Thread.sleep(2000);
				
				if(Rate_TextBox.getText().equalsIgnoreCase(HSN_Rate))
				{
						
					Create_Button.click();
					
					Thread.sleep(2000);
					
					if(driver.switchTo().alert().getText().equalsIgnoreCase("HSN Created Successfully"))
					{
						driver.switchTo().alert().accept();
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
			else if(HSN_Entry.equalsIgnoreCase("Manual"))
			{
				HSN_Entry_Manual_Radio_Button.click();
				
				HSN_Code_TextBox.clear();
				HSN_Code_TextBox.sendKeys(HSN_Code);
				
				HSN_Desc_Text.clear();
				HSN_Desc_Text.sendKeys(HSN_Desc);
				
				Select rate_dropdown=new Select(Rate_DropDown);
				rate_dropdown.selectByIndex(5);
				
				Create_Button.click();
				
				Thread.sleep(2000);
				if(driver.switchTo().alert().getText().equalsIgnoreCase("HSN Created Successfully"))
				{
					driver.switchTo().alert().accept();
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
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
			
	}
	
	/**
	 * @param hsn_Code
	 * @param hsn_Desc
	 * @param hsn_Rate
	 * @param hsn_Type
	 * @param ActionType
	 * @return
	 * @throws InterruptedException
	 */
	public boolean searchHSNAndAction(String hsn_Code, String hsn_Desc, String hsn_Rate, String hsn_Type,String ActionType) throws InterruptedException
	{
		int size= HSN_List.size();
	
		for(int i=1; i<=size; i++)
		{
			if(driver.findElement(By.xpath(".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(hsn_Code)
					&& 	driver.findElement(By.xpath(".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(hsn_Desc)
					&& driver.findElement(By.xpath(".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr["+i+"]/td[5]")).getText().equalsIgnoreCase(hsn_Type)
					&& driver.findElement(By.xpath(".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr["+i+"]/td[4]")).getText().equalsIgnoreCase(hsn_Rate)
			)
			{
				//System.out.println("Inside");
				if(ActionType.equalsIgnoreCase("Edit"))
				{
					driver.findElement(By.xpath(".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr["+i+"]/td[6]/input[@value='Edit']")).click();
					return true;
				}
				else if(ActionType.equalsIgnoreCase("Delete"))
				{
					driver.findElement(By.xpath(".//table[@class='table table-striped table-bordered table-hover gridtable']/tbody/tr["+i+"]//td/a[@tooltip='Delete']")).click();
					return true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					return false;
				}
					
				
			}	
			
		}
		screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		return false;
		
	}
	
	/**
	 * @param hsn_Code
	 * @param hsn_Desc
	 * @param hsn_Rate
	 * @param hsn_Type
	 * @return
	 * @throws InterruptedException
	 */
	public boolean edit_HSN_Details(String hsn_Code, String hsn_Desc, String hsn_Rate, String hsn_Type,String Expected) throws InterruptedException
	{
		Boolean res=HSN_Creation_menuClick();
		
		if(res)
		{
			Thread.sleep(3000);
			res=searchHSNAndAction(hsn_Code, hsn_Desc, hsn_Rate, hsn_Type,"Edit");
			if(res)
			{
					Thread.sleep(3000);
					
							
				System.out.println(driver.getWindowHandles().size());
				
				//driver.switchTo().activeElement();
				
				Edit_HSN_Code_TextBox.clear();
				Edit_HSN_Code_TextBox.sendKeys(hsn_Code);
				
				Edit_HSN_Desc_TextBox.clear();
				Edit_HSN_Desc_TextBox.sendKeys(hsn_Desc);
				
				Select hsnRate=new Select(Edit_Rate);
				hsnRate.selectByVisibleText(hsn_Rate);
				
				Update_Button.click();
				
				if(driver.switchTo().alert().getText().equalsIgnoreCase("HSN Updated Successfully"))
				{
					driver.switchTo().alert().accept();
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
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
			
	}
	
	/**
	 * @param hsn_Code
	 * @param hsn_Desc
	 * @param hsn_Rate
	 * @param hsn_Type
	 * @return
	 * @throws InterruptedException
	 */
	public Boolean delete_HSN_Details(String hsn_Code, String hsn_Desc, String hsn_Rate, String hsn_Type ) throws InterruptedException
	{
		
			Boolean res=HSN_Creation_menuClick();
			
			if(res)
			{
				Thread.sleep(3000);
				res=searchHSNAndAction(hsn_Code, hsn_Desc, hsn_Rate, hsn_Type,"Delete");
				if(res)
				{
					
					Thread.sleep(4000);
					if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Delete?"))
					{
						driver.switchTo().alert().accept();
						Thread.sleep(4000);
						if(driver.switchTo().alert().getText().equalsIgnoreCase("HSN Deleted Successfully"))
						{
							driver.switchTo().alert().accept();
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
