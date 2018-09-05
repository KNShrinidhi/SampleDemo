package com.wep.wepasppanel.pomclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wep.wepasppanel.constants.CommonFunctions;
import com.wep.wepasppanel.constants.Screenshot;

public class NiLRateInvoices_Page 
{
	public WebDriver driver;
	
	Screenshot screenshot=new Screenshot();
	
	Outward_Register_Page outward;
	
	@FindBy(id="cgstin")
	public WebElement GSTINDropDown;
	
	@FindBy(name="Period")
	public WebElement Period_TextBox;
	
	@FindBy(name="supplytype")
	public WebElement SupplyTypeDropDown;
	
	@FindBy(id="nilrated")
	public WebElement NilRatedSupplies_TextBox;
	
	@FindBy(id="exempted")
	public WebElement ExemptedSupplies_TextBox;
	
	@FindBy(id="non-gst")
	public WebElement NonGSTSupplies_TextBox;
	
	@FindBy(id="btnsubmit")
	public WebElement Save_Button;
	
//	Edit Nil rated pages
	@FindBy(name="cgstin")
	public WebElement GSTINNo_TextBox;
	
	@FindBy(name="Period")
	public WebElement Period_TextBOx;
	
	@FindBy(name="supplytype")
	public WebElement SupplyType_TextBox;
	
		
	public NiLRateInvoices_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		outward=new Outward_Register_Page(driver);
	}
	
	public Boolean Create_NiLRated_Invoice(String GSTINNO, String Period, String Supply_Type, String NilRateSupplies, String ExemptSupplies, String NoNGSTSupplies)
	{
		Boolean flag=false;
		if(outward.NilRate_Menu_Click())
		{
			Select GSTINNoDropDown=new Select(GSTINDropDown);
			GSTINNoDropDown.selectByVisibleText(GSTINNO);
			
			Period_TextBox.clear();
			Period_TextBox.sendKeys(Period);
			
			Select SupplyType=new Select(SupplyTypeDropDown);
			SupplyType.selectByVisibleText(Supply_Type);
			
			NilRatedSupplies_TextBox.clear();
			if(NilRateSupplies.isEmpty())
			{
				NilRatedSupplies_TextBox.sendKeys("0");
			}
			else
			{
				NilRatedSupplies_TextBox.sendKeys(NilRateSupplies);
			}
			
			ExemptedSupplies_TextBox.clear();
			if(ExemptSupplies.isEmpty())
			{
				ExemptedSupplies_TextBox.sendKeys("0");
			}
			else
			{
				ExemptedSupplies_TextBox.sendKeys(ExemptSupplies);
			}
			
			NonGSTSupplies_TextBox.clear();
			if(NoNGSTSupplies.isEmpty())
			{
				NonGSTSupplies_TextBox.sendKeys("0");
			}
			else
			{
				NonGSTSupplies_TextBox.sendKeys(NoNGSTSupplies);
			}
			
			Save_Button.click();
			if(CommonFunctions.isAlertPresent(driver))
			{
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Saved Successfully"))
				{
					driver.switchTo().alert().accept();
					flag=true;
				}
				else
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.navigate().back();
				}
			}
			else
			{
				screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
				driver.navigate().back();
				if(CommonFunctions.isAlertPresent(driver))
				{
					screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					driver.switchTo().alert().accept();
				}
			}
			
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			flag=false;
		}
		if(flag)
			return flag;
		else
			return false;
	}		
	
		
	
	public Boolean Edit_NilRated_Invoices(String GSTINNo, String Period, String SupplyType, String NilRatedSupplies, String ExemptedSupplies, String NonGSTSupplies) throws InterruptedException
	{
		Boolean Flag=false;
		if(outward.GSTR1DataEdit_menu_Click() & outward.ActionSelection("NIL") & outward.search(GSTINNo))
		{
			int resultSetSize=driver.findElements(By.xpath(".//table[@id='example']/tbody/tr")).size();
			for(int i=1;i<=resultSetSize;i++)
			{
				if(driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(GSTINNo) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(Period) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText().equalsIgnoreCase(SupplyType))
				{
					driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[5]/a[text()='Edit']")).click();
					Thread.sleep(1000);
					if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Edit?"))
					{
						driver.switchTo().alert().accept();
						Thread.sleep(3000);
						
						if(GSTINNo_TextBox.getText().equalsIgnoreCase(GSTINNo) & Period_TextBOx.getText().equalsIgnoreCase(Period) & SupplyType_TextBox.getText().equalsIgnoreCase(SupplyType))
						{
							NilRatedSupplies_TextBox.clear();
							if(NilRatedSupplies.isEmpty())
							{
								NilRatedSupplies_TextBox.sendKeys("0");
							}
							else
							{
								NilRatedSupplies_TextBox.sendKeys(NilRatedSupplies);
							}
							
							ExemptedSupplies_TextBox.clear();
							if(NilRatedSupplies.isEmpty())
							{
								ExemptedSupplies_TextBox.sendKeys("0");
							}
							else
							{
								ExemptedSupplies_TextBox.sendKeys(NilRatedSupplies);
							}
							
							NonGSTSupplies_TextBox.clear();
							if(NonGSTSupplies.isEmpty())
							{
								NonGSTSupplies_TextBox.sendKeys("0");
							}
							else
							{
								NonGSTSupplies_TextBox.sendKeys(NonGSTSupplies);
							}
							
							Save_Button.click();
							if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Updated Successfully"))
							{
								driver.switchTo().alert().accept();
								Flag=true;
							}
							else
							{
								screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
								driver.navigate().back();
								Flag=false;
							}
						}
					}
				}
			}
		}
		
		if(Flag)
			return Flag;
		else
			return false;
		
	}
	
	public Boolean Delete_NiLRated_Invoices(String GSTINNo, String Period, String SupplyType) throws InterruptedException
	{
		Boolean Flag=false;
		if(outward.GSTR1DataEdit_menu_Click() & outward.ActionSelection("NIL") & outward.search(GSTINNo))
		{
			int resultSetSize=driver.findElements(By.xpath(".//table[@id='example']/tbody/tr")).size();
			for(int i=1;i<=resultSetSize;i++)
			{
				if(driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(GSTINNo) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(Period) & driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText().equalsIgnoreCase(SupplyType))
				{
					driver.findElement(By.xpath(".//table[@id='example']/tbody/tr["+i+"]/td[6]/a[text()='Delete']")).click();
					
					if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Delete?"))
					{
						driver.switchTo().alert().accept();
						
						Thread.sleep(1000);
						
						if(driver.switchTo().alert().getText().equalsIgnoreCase("Invoice Deleted Successfully"))
						{
							driver.switchTo().alert().accept();
							Flag=true;
						}
					}
				}
			}
		}
		if(Flag)		
			return Flag;
		else
			return false;

	}
}
