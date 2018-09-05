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

public class Reports {
	
	public WebDriver driver;
		
	@FindBy(xpath="//*[@title='Reports']")
	public WebElement ReportsMenu;
	
	@FindBy(xpath="//a[@title='GSTIN Sales Summary']")
	public WebElement GSTIN_Sales_SummaryMenu;
	
	@FindBy(xpath="//*[@id='periodidr']")
	public WebElement Period_TextBox;
	
	@FindBy(id="cgstin")
	public WebElement GSTINDropDown;
	
//	GSTINwise Sales Summary Report
	@FindBy(xpath="//*[@id='sales']")
	public WebElement SalesSummary_ViewReportButton;
	
//	Supplier Inward Report
	@FindBy(xpath="//*[@id='supplier']")
	public WebElement Supplier_ViewReportButton;
	
//	GSTINwise Purchase Report
	@FindBy(xpath="//*[@id='purchase']")
	public WebElement Purchase_ViewReportButton;
	
//	Customer Sales Report
	@FindBy(xpath="//*[@id='customer']")
	public WebElement CustomerSales_ViewReportButton;
	
//	Sales Invoice wise Report
	@FindBy(xpath="//button[@id='invoice']")
	public WebElement SalesInvoice_ViewReportButton;
	
	@FindBy(xpath="//a[@title='GSTIN Purchase Summary']")
	public WebElement GSTIN_Purchase_SummaryMenu;
	
	@FindBy(xpath="//a[@title='Sales Summary – Invoice type']")
	public WebElement Sales_Summary_InvoiceTypeMenu;
	
	@FindBy(xpath="//a[@title='Customer Sales Report – B2B']")
	public WebElement Customer_Sales_Report_Menu;
	
	@FindBy(xpath="//a[@title='Supplier Inward Register']")
	public WebElement Supplier_Inward_Register_Menu;
	
	@FindBy(id="sales")
	public WebElement ExportButton;
	
	
	@FindBy(xpath="//a[@title='AuditLog Report']")
	WebElement AuditLog_Menu;
	
	@FindBy(name="period")
	public WebElement Period_TextBox_LogFilePage;
	
	@FindBy(xpath="//*[@name='Export']")
	public WebElement Export;
	
	@FindBy(xpath="//a[@title='Log Files']")
	public WebElement LogMenu;

	@FindBy(name="from")
	public WebElement fromDateTextBox;
	
	@FindBy(name="to")
	public WebElement toDateTextBox;
	
	@FindBy(xpath=".//form[@id='checkout-form']//button")
	public WebElement viewInfoButton;
	
//  Search result list	
	@FindBy(xpath=".//table[@id='example']/tbody/tr")
	public List<WebElement> resultList;
	
	Screenshot screenshot=new Screenshot();
	
	public  Reports(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public Boolean Reports_Menu_Click() throws Exception
	{
		if(!(GSTIN_Sales_SummaryMenu.isDisplayed()))
		{
			ReportsMenu.click();
			
			if(GSTIN_Sales_SummaryMenu.isDisplayed())
				return true;
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				return false;
			}
				
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return true;
		}
	}
	
	public Boolean GSTIN_Sales_Summary_Menu_Click() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		if(res)
		{
			GSTIN_Sales_SummaryMenu.click();
			Thread.sleep(2000);
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTINSalesSummaryPage)))
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
	
	public Boolean GSTIN_Purchase_Summary_menuClick() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		if(res)
		{
			GSTIN_Purchase_SummaryMenu.click();
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.GSTINPurchaseSummaryPage)))
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
	
	
	public Boolean Sales_Summary_InvoiceType_MenuClick() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		if(res)
		{
//			Actions actions = new Actions(driver);
//			actions.moveToElement(Sales_Summary_InvoiceTypeMenu).perform();
			Sales_Summary_InvoiceTypeMenu.click();
			Thread.sleep(1000);
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.SalesSummaryInvoicetypePage)))
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
	
	public Boolean Customer_Sales_Report_B2B_MenuClick() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		if(res)
		{
			Customer_Sales_Report_Menu.click();
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.CustomerSalesReportB2BPage)))
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

	public Boolean Supplier_Inward_Register_MenuClick() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		if(res)
		{
			Supplier_Inward_Register_Menu.click();
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.SupplierInwardRegisterPage)))
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
	
	public Boolean AuditLog_MenuList() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		System.out.println(res);
		if(res)
		{
			AuditLog_Menu.click();
			Thread.sleep(2000);
			
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.AuditLogReportPage)))
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
	
	
	public Boolean LogFiles_MenuClick() throws Exception
	{
		Boolean res=Reports_Menu_Click();
		if(res)
		{
			LogMenu.click();
			Thread.sleep(1000);
			if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.LogFilesPage)))
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

	public Boolean GSTIN_Sales_SummaryReport(String PeriodID, String GSTINNo) throws Exception
	{
		Boolean flag=false;
		Boolean res=GSTIN_Sales_Summary_Menu_Click();
		if(res)
		{
			Period_TextBox.clear();
			Period_TextBox.sendKeys(PeriodID);
        
			Select select_dropdown_GSTIN = new Select(GSTINDropDown);
			select_dropdown_GSTIN.selectByVisibleText(GSTINNo);
				
			SalesSummary_ViewReportButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equals("No data found"))
	            {
					driver.switchTo().alert().accept();
					flag=true;
		        }
				else
				{
					ExportButton.click();
					flag=true;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
			}
		}
		if(flag)
			return flag;
		else
			return false;
	}
	
	public Boolean GSTIN_Purchase_Summary(String PeriodID, String GSTINNo) throws Exception
	{
		Boolean flag=false;
		Boolean res=GSTIN_Purchase_Summary_menuClick();
		if(res)
		{
			Period_TextBox.clear();
			Period_TextBox.sendKeys(PeriodID);
        
			Select select_dropdown_GSTIN = new Select(GSTINDropDown);
			select_dropdown_GSTIN.selectByVisibleText(GSTINNo);
				
			Purchase_ViewReportButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equals("No data found"))
	            {
					driver.switchTo().alert().accept();
					flag=true;
		        }
				else
				{
					ExportButton.click();
					flag=true;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
			}
		}
		if(flag)
			return flag;
		else
			return false;
	}
	
	public Boolean Sales_Summary_InvoiceType(String PeriodID,String GSTINNo) throws Exception
	{
		Boolean flag=false;
		Boolean res=Sales_Summary_InvoiceType_MenuClick();
		if(res)
		{
			Period_TextBox.clear();
			Period_TextBox.sendKeys(PeriodID);
        
			Select select_dropdown_GSTIN = new Select(GSTINDropDown);
			select_dropdown_GSTIN.selectByVisibleText(GSTINNo);
			Thread.sleep(3000);
			SalesInvoice_ViewReportButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equals("No data found"))
	            {
					driver.switchTo().alert().accept();
					flag=true;
		        }
				else
				{
					ExportButton.click();
					flag=true;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
			}
		}
		if(flag)
			return flag;
		else
			return false;
	}
	
	
	
	
	public Boolean Customer_Sales_Report(String PeriodID, String GSTINNo) throws Exception
	{
		Boolean flag=false;
		Boolean res=Customer_Sales_Report_B2B_MenuClick();
		if(res)
		{
			Period_TextBox.clear();
			Period_TextBox.sendKeys(PeriodID);
        
			Select select_dropdown_GSTIN = new Select(GSTINDropDown);
			select_dropdown_GSTIN.selectByVisibleText(GSTINNo);
				
			CustomerSales_ViewReportButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equals("No data found"))
	            {
					driver.switchTo().alert().accept();
					flag=true;
		        }
				else
				{
					ExportButton.click();
					flag=true;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
			}
		}
		if(flag)
			return flag;
		else
			return false;
	}
	
	
	
	
	public Boolean Supplier_Inward_Register(String PeriodID,String GSTINNo) throws Exception
	{
		Boolean res=Supplier_Inward_Register_MenuClick();
		Boolean flag=false;
		if(res)
		{
			Period_TextBox.clear();
			Period_TextBox.sendKeys(PeriodID);
        
			Select select_dropdown_GSTIN = new Select(GSTINDropDown);
			select_dropdown_GSTIN.selectByVisibleText(GSTINNo);
				
			Supplier_ViewReportButton.click();
			
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equals("No data found"))
	            {
					driver.switchTo().alert().accept();
					flag=true;
		        }
				else
				{
					ExportButton.click();
					flag=true;
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
			}
		}
		if(flag)
			return flag;
		else
			return false;
	}
	
	
	public Boolean Audit_Log_Report(String fromDate, String toDate) throws Exception
	{
		Boolean res=AuditLog_MenuList();
		if(res)
		{
			fromDateTextBox.clear();
			fromDateTextBox.sendKeys(fromDate);
		
			toDateTextBox.clear();
			toDateTextBox.sendKeys(toDate);
		
			viewInfoButton.click();
		
			if(resultList.size()>1)
				return true;
			else
				return false;
		}
		else
			return false;
		
	}

   /**
    * 
    * @return
    * @throws Exception
    */
	public Boolean Log_List(String PeriodId) throws Exception
	{
		Boolean res=LogFiles_MenuClick();
		if(res)
		{
//			Period_TextBox_LogFilePage.clear();
			Period_TextBox_LogFilePage.sendKeys(PeriodId);
			Thread.sleep(2000);
			return true;
		}
		else
			return false;
	}
}
