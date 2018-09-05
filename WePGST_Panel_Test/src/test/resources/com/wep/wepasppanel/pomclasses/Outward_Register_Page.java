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

public class Outward_Register_Page 
{
	public WebDriver driver;
	
//	Outward Register menu	
	@FindBy(xpath=".//li/a[@title='Outward Register']")
	public WebElement Outward_Register_Menu;
	
//	B2B invoice menu
	@FindBy(xpath=".//li/a[@title='B2B Invoices']")
	public WebElement B2B_Invoices_Menu;
	
//	B2CL invoice menu
	@FindBy(xpath=".//li/a[@title='B2CL Invoices']")
	public WebElement B2CL_Invoices_Menu;
	
//	B2CS invoice menu
	@FindBy(xpath=".//li/a[@title='B2CS Invoices']")
	public WebElement B2CS_Invoices_Menu;
	
//	Credit/Debit Note menu
	@FindBy(xpath=".//li/a[@title='Credit / Debit Note']")
	public WebElement Credit_Debit_Menu;
	
//	EXP invoice menu
	@FindBy(xpath=".//li/a[@title='EXP Invoices']")
	public WebElement Exp_Invoices_Menu;
	
//	AT and TXP invoice menu
	@FindBy(xpath=".//li/a[@title='AT/TXP Invoices']")
	public WebElement AT_TXP_Menu;
	
//	Doc Issue invoice menu
	@FindBy(xpath=".//li/a[@title='Doc Issue Invoices']")
	public WebElement Doc_Issue_Menu;
	
//	NIL rated invoice menu
	@FindBy(xpath=".//li/a[@title='NIL Rated Invoices']")
	public WebElement NIL_Rated_Menu;
	
//	GSTR1 Invoice Edit menu
	@FindBy(xpath=".//li/a[@title='Invoice Generation']")
	public WebElement InvoiceGeneration_Menu;
	
//	GSTR-1 Data Edit menu
	@FindBy(xpath=".//li/a[@title='GSTR1 Data Edit']")
	public WebElement GSTR1_Data_Edit_Menu;
	
//	Invoice Settings menu
	@FindBy(xpath=".//li/a[@title='Invoice Settings']")
	public WebElement Invoice_Setting_Menu;
	
//	GSTIN Drop Down in AT/TXP page
	@FindBy(xpath=".//select[@id='cgstin']")
	public WebElement Gstin_Dropdown;
	
//	Period text box
	@FindBy(xpath=".//input[@id='period']")
	public WebElement Period_TextBox;
	
//	Type Drop_Down
	@FindBy(xpath=".//select[@id='actiontype']")
	public WebElement Type_Dropdown;
	
//	Rate Drop_down
	@FindBy(xpath=".//select[@id='rate']")
	public WebElement Rate_Dropdown;
	
//	POS text box
	@FindBy(xpath=".//input[@id='pos']")
	public WebElement Place_Of_Supply_Textbox;
	
//	Advance Amount text box
	@FindBy(xpath=".//input[@id='ad_amt']")
	public WebElement Advance_Amount_Textbox;
	
//	Cess Amount text box
	@FindBy(xpath=".//input[@name='csamount']")
	public WebElement Cess_Amount_Textbox;
	
//	Add Item line Button
	@FindBy(xpath=".//button[@id='btnSubmit']")
	public WebElement Add_ItemLine_Button;
	
//	Delete Item Line
	@FindBy(xpath=".//a[text()='Delete']")
	public WebElement Delete_ItemLine_button;
	
//	Save Button
	@FindBy(xpath=".//button[@value='save']")
	public WebElement Save_button;
	
//  Action drop down
	@FindBy(xpath=".//select[@id='Action']")
	public WebElement ActionDropDown;
	
//  Search result list	
	@FindBy(xpath=".//table[@id='example']/tbody/tr")
	public List<WebElement> resultList;
	
//  ResultCell 
	@FindBy(xpath=".//table[@id='example']/tbody/tr[1]/td[1]")
	public List<WebElement> resultCell;

//	GSTR1 Data Edit Page
//  Search Text box
	@FindBy(xpath=".//input[@type='search']")
	public WebElement searchTextBox;
	
//	Edit AT invoice details
//  Existing Item List	
	@FindBy(xpath=".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr")
	public List<WebElement> existingItemList;
	
// Doc Issues Page
//	Period text box
	@FindBy(xpath=".//input[@name='Period']")
	public WebElement fp_TextBox;
	
//	DocType
	@FindBy(xpath=".//select[@id='DocType']")
	public WebElement DocType_Dropdown;
	
//	From Serial No
	@FindBy(xpath=".//input[@id='FromSno']")
	public WebElement From_Serial_No_TextBox;
	
//	To Serial No
	@FindBy(xpath=".//input[@id='ToSno']")
	public WebElement To_Serial_No_TextBox;
	
//	Total Invoice count
	@FindBy(xpath=".//input[@id='Total']")
	public WebElement Total_Count_TextBox;
	
//	Total cancelled invoice
	@FindBy(xpath=".//input[@id='Cancelled']")
	public WebElement Total_Cancelled_TextBox;
	
//	Add Button
	@FindBy(xpath=".//button[@id='btnSubmit']")
	public WebElement Add_button;
	
//	Edit Deoc Issue Page
//	DocType
	@FindBy(xpath=".//select[@name='DocTpe']")
	public WebElement DocType_Dropdown_Edit;
	
//  Existing Item List	
	@FindBy(xpath=".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr")
	public List<WebElement> existingDocIssueItemList;
	
	Screenshot screenshot=new Screenshot();
	
	public Outward_Register_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
//	Click on Outward Menu
	public Boolean Outward_register_menu_click()
	{
		if(B2B_Invoices_Menu.isDisplayed())
		{
			return true;
		}
		else
		{
			Outward_Register_Menu.click();
			if(B2B_Invoices_Menu.isDisplayed())
				return true;
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
				return false;
			}
		}
	}
	
	public Boolean B2BInvoice_MenuClick()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			B2B_Invoices_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.B2BInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
	public Boolean B2CLInvoice_MenuClick()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			B2CL_Invoices_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.B2CLInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
	public Boolean B2CSInvoice_MenuClick()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			B2CS_Invoices_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.B2CSInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
	public Boolean CDNRInvoice_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			Credit_Debit_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.CreditDebitNotePage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
	public Boolean ExpInvoice_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			Exp_Invoices_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.EXPInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
	public Boolean InvoiceGeneration_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			InvoiceGeneration_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.InvoiceGenerationPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
//	Click on At and TXP Menu
	public Boolean ATandTXP_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			AT_TXP_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.ATTXPInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
//	Click on Doc Issue Menu
	public Boolean DocIssue_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			Doc_Issue_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.DocIssueInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
	public Boolean InvoiceSetting_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			Invoice_Setting_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.InvoiceSettingsPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
//	Click on Doc Issue Menu
	public Boolean NilRate_Menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			NIL_Rated_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.NILRatedInvoicesPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
//	Click on GSTR1 Data Edit Menu
	public Boolean GSTR1DataEdit_menu_Click()
	{
		Boolean res=Outward_register_menu_click();
		if(res)
		{
			GSTR1_Data_Edit_Menu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1DataEditPage)))
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
			driver.navigate().back();
			return false;
		}
	}
	
//	Select the Action in GSTR-1 Data Edit Page
	public Boolean ActionSelection(String action_name)
	{
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTR1DataEditPage)))
		{
			Select action_dropdown=new Select(ActionDropDown);
			action_dropdown.selectByVisibleText(action_name);
			if(resultList.size()>=1 )
				return true;
			else
				return false;
			
		}
		else
		{
			return false;
		}
	}
	
	public boolean search(String Search_Value) throws InterruptedException
	{
		searchTextBox.clear();
		searchTextBox.sendKeys(Search_Value);
		Thread.sleep(2000);
		
		if(resultList.size()==1 & !(resultCell.get(0).getText().equalsIgnoreCase("No matching records found")))
			return true;
		else
			return false;
		
	}
	public Boolean Create_ATTXP_Invoices(String GSTINNo, String period, String type, String rate, String pos, String advance_amount, String cess_amount)
	{
		if(ATandTXP_Menu_Click())
		{
			Select gstin_dropdpwn=new Select(Gstin_Dropdown);
			gstin_dropdpwn.selectByVisibleText(GSTINNo);
			
			Period_TextBox.clear();
			Period_TextBox.sendKeys(period);
			
			Select action_type=new Select(Type_Dropdown);
			action_type.selectByVisibleText(type);
			
			Select rate_dropdown=new Select(Rate_Dropdown);
			rate_dropdown.selectByVisibleText(rate);
			
			Place_Of_Supply_Textbox.clear();
			Place_Of_Supply_Textbox.sendKeys(pos);
			
			Advance_Amount_Textbox.clear();
			Advance_Amount_Textbox.sendKeys(advance_amount);
			
			Cess_Amount_Textbox.clear();
			Cess_Amount_Textbox.sendKeys(cess_amount);
			
			Add_ItemLine_Button.click();
			
			Save_button.click();
			
			if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Saved Successfully"))
			{
				driver.switchTo().alert().accept();
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
	
		
	
	
	@SuppressWarnings("unused")
	public boolean Edit_AT_Invoices(String GSTINNo, String period, String type, String rate, String pos, String advance_amount, String cess_amount,String action_name) throws InterruptedException
	{
		if(GSTR1DataEdit_menu_Click())
		{
			if(ActionSelection(type))
			{
				if(search(GSTINNo))
				{
					int resultSetSize=driver.findElements(By.xpath(".//table[@id='example']/tbody/tr")).size();
					for(int i=1;i<=resultSetSize;i++)
					{
						if(driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(GSTINNo) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(period))
						{
							driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[4]/a[text()='Edit']")).click();
							Thread.sleep(1000);
							if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Edit?"))
							{
								driver.switchTo().alert().accept();
								Thread.sleep(3000);
								
								if(action_name.equalsIgnoreCase("Update"))
								{
									return edit_item_line(rate, pos, advance_amount, cess_amount);
								}
								else if(action_name.equalsIgnoreCase("Delete"))
								{
									return delete_item_line(rate, pos, advance_amount, cess_amount);
								}
								else if(action_name.equalsIgnoreCase("Add"))
								{
									return add_item_line(rate, pos, advance_amount, cess_amount);
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
								driver.navigate().back();
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
				driver.navigate().back();
				return false;
			}
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			driver.navigate().back();
			return false;
		}
		return false;
		
	}
	
	public boolean edit_item_line(String rate, String pos, String ad_amount, String cs_amount)
	{
		boolean res=false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int j=1;j<=existingItemList.size();j++)
		{
//			System.out.println(driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).getAttribute("value"));
			if(driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[1]//input")).getAttribute("value").equalsIgnoreCase(rate) & driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[2]//input")).getAttribute("value").equalsIgnoreCase(pos))
			{
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).clear();
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).sendKeys(ad_amount);
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[7]//input")).clear();
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[7]//input")).sendKeys(cs_amount);
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[8]//input")).click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Item  Details Updated Successfully"))
				{
					driver.switchTo().alert().accept();
					res=true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.navigate().back();
					res=false;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				res=false;
			}
		}
		
		if(res)
			return true;
		else
			return false;
	}
	
	public boolean delete_item_line(String rate, String pos, String ad_amount, String cs_amount)
	{
		boolean res=false;
		for(int j=1;j<=existingItemList.size();j++)
		{
			if(driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[1]//input")).getAttribute("value").equalsIgnoreCase(rate) & driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[2]//input")).getAttribute("value").equalsIgnoreCase(pos))
			{
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[9]//input")).click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Item Deleted Successfully"))
				{
					driver.switchTo().alert().accept();
					res=true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.navigate().back();
					res=false;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				res=false;
			}
		}
		
		
		if(res)
			return true;
		else
			return false;
	}
	
	public boolean add_item_line(String rate, String pos, String ad_amount, String cs_amount)
	{
		Select rate_dropdown=new Select(Rate_Dropdown);
		rate_dropdown.selectByVisibleText(rate);
		
		Place_Of_Supply_Textbox.clear();
		Place_Of_Supply_Textbox.sendKeys(pos);
		
		Advance_Amount_Textbox.clear();
		Advance_Amount_Textbox.sendKeys(ad_amount);
		
		Cess_Amount_Textbox.clear();
		Cess_Amount_Textbox.sendKeys(cs_amount);
		
		Add_ItemLine_Button.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(driver.switchTo().alert().getText().equalsIgnoreCase("Item Saved Successfully"))
		{
			driver.switchTo().alert().accept();
			return true;
		}
		else
			return false;
	}
	
	@SuppressWarnings("unused")
	public boolean Delete_AT_Invoices(String Type,String GSTINNo, String period) throws InterruptedException
	{
		if(GSTR1DataEdit_menu_Click())
		{
			if(ActionSelection(Type))
			{
				if(search(GSTINNo))
				{
					int resultSetSize=driver.findElements(By.xpath(".//table[@id='example']/tbody/tr")).size();
					for(int i=1;i<=resultSetSize;i++)
					{
						if(driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(GSTINNo) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(period))
						{
							driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[5]/a[text()='Delete']")).click();
							Thread.sleep(1000);
							if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Delete?"))
							{
								driver.switchTo().alert().accept();
								Thread.sleep(3000);
								if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Deleted Successfully"))
								{
									driver.switchTo().alert().accept();
									return true;
								}
									
								else
									return false;
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
							driver.navigate().back();
							return false;
						}
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
				driver.navigate().back();
				return false;
			}
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			driver.navigate().back();
			return false;
		}
		return false;
		
	}
	
	public boolean Create_Doc_Issue_Invoices(String GSTINo, String Period, String DocType, String FromSerialNo, String ToSerialNo, String TotalInvCount, String Cancalled)
	{
		if(DocIssue_Menu_Click())
		{
		
			Select GSTIN_DropDown=new Select(Gstin_Dropdown);
			GSTIN_DropDown.selectByVisibleText(GSTINo);
		
			fp_TextBox.clear();
			fp_TextBox.sendKeys(Period);
		
			Select DocType_DropDown=new Select(DocType_Dropdown);
			DocType_DropDown.selectByVisibleText(DocType);
			
			From_Serial_No_TextBox.clear();
			From_Serial_No_TextBox.sendKeys(FromSerialNo);
			
			To_Serial_No_TextBox.clear();
			To_Serial_No_TextBox.sendKeys(ToSerialNo);
			
			Total_Count_TextBox.clear();
			Total_Count_TextBox.sendKeys(TotalInvCount);
			
			Total_Cancelled_TextBox.clear();
			Total_Cancelled_TextBox.sendKeys(Cancalled);
			
			Add_button.click();
			
			Save_button.click();
			
			if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Saved Successfully"))
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
			driver.navigate().back();
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public boolean Edit_DocIssue_Invoices(String GSTINNo, String period, String DocType, String FromSNo, String ToSNo, String TotalInvCount, String CancelledInvCount,String action_name) throws InterruptedException
	{
		Boolean flag=false;
		if(GSTR1DataEdit_menu_Click())
		{
			if(ActionSelection("DOCIssue"))
			{
				if(search(GSTINNo))
				{
					int resultSetSize=driver.findElements(By.xpath(".//table[@id='example']/tbody/tr")).size();
					for(int i=1;i<=resultSetSize;i++)
					{
						if(driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(GSTINNo) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(period))
						{
							driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[4]/a[text()='Edit']")).click();
							Thread.sleep(1000);
							if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Edit?"))
							{
								flag=true;
								driver.switchTo().alert().accept();
								Thread.sleep(3000);
								
								if(action_name.equalsIgnoreCase("Update"))
								{
									return Edit_DocIssue_ItemLine(DocType, FromSNo, ToSNo, TotalInvCount,CancelledInvCount);
								}
								else if(action_name.equalsIgnoreCase("Delete"))
								{
									return Delete_Item_Line_DocIssue(DocType, FromSNo, ToSNo);
								}
								else if(action_name.equalsIgnoreCase("Add"))
								{
									return Add_New_ItemLine_DocIssue(DocType, FromSNo, ToSNo, TotalInvCount, CancelledInvCount);
								}
								else
								{
									screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
									return false;
								}
							}
//							else
//							{
//								screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
//								driver.navigate().back();
//								return false;
//							}
						}
//						else
//						{
//							screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
//							driver.navigate().back();
//							return false;
//						}
					}
				}
//				else
//				{
//					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
//					driver.navigate().back();
//					return false;
//				}
			}
//			else
//			{
//				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
//				driver.navigate().back();
//				return false;
//			}
		}
//		else
//		{
//			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
//			driver.navigate().back();
//			return false;
//		}
		if(flag==false)
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			driver.navigate().back();
			
		}
		return flag;
	}
	
	

	public Boolean Edit_DocIssue_ItemLine(String DocType, String FromSNo, String ToSNo, String TotalInvNo, String CancelledInvCount)
	{
		boolean res=false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int j=1;j<=existingDocIssueItemList.size();j++)
		{
//			System.out.println(driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward AT Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).getAttribute("value"));
			if(driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[1]//input")).getAttribute("value").equalsIgnoreCase(DocType))
			{
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[2]//input[@type='text']")).clear();
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[2]//input[@type='text']")).sendKeys(FromSNo);
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).clear();
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).sendKeys(ToSNo);
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[4]//input")).clear();
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[4]//input")).sendKeys(TotalInvNo);
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[5]//input")).clear();
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[5]//input")).sendKeys(CancelledInvCount);
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[7]//input")).click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Item Details Updated Successfully"))
					{
						driver.switchTo().alert().accept();
						res=true;
					}
					else
					{
						screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
						driver.navigate().back();
//						res=false;
					}
				
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				res=false;
			}
		}
		
		if(res)
			return true;
		else
			return false;
		
	}
	
	public boolean Delete_Item_Line_DocIssue(String DocType, String FromSNo, String ToSNo)
	{
		boolean res=false;
		for(int j=1;j<=existingDocIssueItemList.size();j++)
		{
			if(driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[1]//input")).getAttribute("value").equalsIgnoreCase(DocType) & driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[2]//input[@type='text']")).getAttribute("value").equalsIgnoreCase(FromSNo) & driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[3]//input")).getAttribute("value").equalsIgnoreCase(ToSNo))
			{
				
				driver.findElement(By.xpath(".//div[@role='widget']/header/h2[text()='Update Outward DOCIssue Item Details']/../../div//table/tbody/tr["+j+"]/td[8]//input")).click();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Item Deleted Successfully"))
				{
					driver.switchTo().alert().accept();
					res=true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.navigate().back();
					res=false;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				res=false;
			}
		}
		
		
		if(res)
			return true;
		else
			return false;
	}
	
	public Boolean Add_New_ItemLine_DocIssue(String DocType, String FromSNo, String ToSNo, String TotalInvCount, String CancelledInvCount)
	{
			
		Select DocType_DropDown=new Select(DocType_Dropdown_Edit);
		DocType_DropDown.selectByVisibleText(DocType);
		
		From_Serial_No_TextBox.clear();
		From_Serial_No_TextBox.sendKeys(FromSNo);
		
		To_Serial_No_TextBox.clear();
		To_Serial_No_TextBox.sendKeys(ToSNo);
		
		Total_Count_TextBox.clear();
		Total_Count_TextBox.sendKeys(TotalInvCount);
		
		Total_Cancelled_TextBox.clear();
		Total_Cancelled_TextBox.sendKeys(CancelledInvCount);
		
		Add_button.click();
		
		if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Saved Successfully"))
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
	
	@SuppressWarnings("unused")
	public boolean Delete_DocIssue_Invoices(String GSTINNo, String period) throws InterruptedException
	{
		if(GSTR1DataEdit_menu_Click())
		{
			if(ActionSelection("DOCIssue"))
			{
				if(search(GSTINNo))
				{
					int resultSetSize=driver.findElements(By.xpath(".//table[@id='example']/tbody/tr")).size();
					for(int i=1;i<=resultSetSize;i++)
					{
						
						if(driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(GSTINNo) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(period))
						{
							driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[5]/a[text()='Delete']")).click();
							Thread.sleep(1000);
							if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Delete?"))
							{
								driver.switchTo().alert().accept();
								Thread.sleep(3000);
								if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Deleted Successfully"))
								{
									driver.switchTo().alert().accept();
									return true;
								}
									
								else
									return false;
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
							driver.navigate().back();
							return false;
						}
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
				driver.navigate().back();
				return false;
			}
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			driver.navigate().back();
			return false;
		}
		return false;
		
	}
	
	public Boolean Create_NiLRated_Invoice(String GSTINNO, String Period, String Supply_Type, String NilRateSupplies, String ExemptSupplies, String NoNGSTSupplies)
	{
		if(NilRate_Menu_Click())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
