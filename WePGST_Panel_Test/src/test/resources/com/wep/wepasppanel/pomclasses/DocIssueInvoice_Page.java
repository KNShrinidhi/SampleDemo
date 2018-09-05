package com.wep.wepasppanel.pomclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wep.wepasppanel.constants.Screenshot;

public class DocIssueInvoice_Page
{
//	GSTIN Drop Down in AT/TXP page
	@FindBy(xpath=".//select[@id='cgstin']")
	public WebElement Gstin_Dropdown;
	
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
		
	public WebDriver driver;
	Outward_Register_Page outward;
	
	public DocIssueInvoice_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		outward=new Outward_Register_Page(driver);
	}
	
	public boolean Create_Doc_Issue_Invoices(String GSTINo, String Period, String DocType, String FromSerialNo, String ToSerialNo, String TotalInvCount, String Cancalled)
	{
		if(outward.DocIssue_Menu_Click())
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
		if(outward.GSTR1DataEdit_menu_Click())
		{
			if(outward.ActionSelection("DOCIssue"))
			{
				if(outward.search(GSTINNo))
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
		if(outward.GSTR1DataEdit_menu_Click())
		{
			if(outward.ActionSelection("DOCIssue"))
			{
				if(outward.search(GSTINNo))
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
}
