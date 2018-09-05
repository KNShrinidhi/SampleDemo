package com.wep.wepasppanel.pomclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wep.wepasppanel.constants.Screenshot;

public class ATTXPInvoice_Page 
{
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
	

	
	public WebDriver driver;
	
	Screenshot screenshot=new Screenshot();
	
	Outward_Register_Page outward;
	
	public ATTXPInvoice_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		outward=new Outward_Register_Page(driver);
	}
	
	public Boolean Create_ATTXP_Invoices(String GSTINNo, String period, String type, String rate, String pos, String advance_amount, String cess_amount)
	{
		if(outward.ATandTXP_Menu_Click())
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
		if(outward.GSTR1DataEdit_menu_Click())
		{
			if(outward.ActionSelection(type))
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
		if(outward.GSTR1DataEdit_menu_Click())
		{
			if(outward.ActionSelection(Type))
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
