package com.wep.wepasppanel.pomclasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wep.wepasppanel.constants.CommonFunctions;
import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;
import com.wep.wepasppanel.constants.Screenshot;

/**
 * 
 * @author Harish Takle
 *
 */

public class Users 
{
	
	
	/**
	 * All the Elements Xpath:
	 */
	
	public WebDriver driver;
	//Role Creation
	@FindBy(xpath="//*[@title='Users']")
	WebElement User_Master_Menu;
	
	@FindBy(xpath="//*[@title='Roles Creation']")
	WebElement Menu_Role_Creation;
	
	
	@FindBy(xpath=".//h2[text()='Roles']")
	WebElement Roles_PageTitle;
	
	@FindBy(xpath=".//*[@placeholder='Enter Role Name to create']")
	WebElement EnterRole;
	
	@FindBy(xpath="//*[@value='ADD']")
	WebElement ClickonAddRole;
	
//	@FindBy(xpath="//*[text()='Supplier']")
//	WebElement Suppliers;
	
	
	@FindBy(xpath="//*[@class='label label-success']")
	WebElement Selectall;
	
	@FindBy(xpath="//*[@id='selectall']")
	WebElement CheckboxClick;
	
	
	@FindBy(xpath=".//*[@id='resource-form']/footer/section/input")
	WebElement Update;
	
	//user Registration
	
	@FindBy(xpath="//*[@title='User Registration']")
	WebElement UserRegistration_Menu;
	
	@FindBy(xpath=".//h2[text()='User Registration ']")
	WebElement UserRegistration_PageTitle;
	
	
	@FindBy(xpath="//*[text()='ADD USER']")
	WebElement AddUser;
	
	@FindBy(xpath="//*[@id='name']")
	WebElement NameofCustomer;
	
	@FindBy(xpath="//*[@id='designation']")
	WebElement Designation;
	
	@FindBy(xpath="//*[@type='email']")
	WebElement EmailId;
	
	
	@FindBy(xpath="//*[@name='Password']")
	WebElement Password;
	
	@FindBy(xpath="//*[@name='phone']")
	WebElement Mobilenumber;
	
	@FindBy(xpath="//*[@id='Role_Name']")
	WebElement SelectRole;
	
	@FindBy(xpath="//*[@name='GSTINId']")
	WebElement SelectGSTIN;
	
	
	@FindBy(xpath=".//*[@id='checkout-form']/footer/button")
	 WebElement RegisterUser;
	
	@FindBy(xpath="//*[@id='option']")
	WebElement SearchType;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement Searchtext;
	
	@FindBy(xpath=".//table[@id='example']/tbody/tr")
	 List<WebElement> resultList;
	
	@FindBy(xpath=".//input[@id='Edit']")
	WebElement editbutton;
	
	@FindBy(xpath=".//p[@class='lead text-muted ']")
	WebElement confirmationPopUp;
	
	@FindBy(xpath=".//button[@class='confirm btn btn-lg btn-danger']")
	WebElement buttonOnPopUp;
	
	@FindBy(xpath=".//button[@class='cancel btn btn-lg btn-default']")
	WebElement cancelButton;
	
	//Edit Users
	@FindBy(xpath="//*[@title='Edit User']")
	WebElement EditUsers_Menu;
	
	@FindBy(xpath=".//h2[text()='EditUser']")
	WebElement EditUsers_PageTitle;
	
	@FindBy(xpath="//*[@id='GSTINNo']")
	WebElement SelectGST;
	
	@FindBy(xpath=".//input[@id='Delete']")
	public WebElement deleteButton;
	
	@FindBy(xpath="//*[@id='GSTINNo']")
	WebElement SearchGSTIN;
	
	@FindBy(xpath="//*[@href='/User/AddUser?gstin=235']")
	WebElement ADDUSER;
	
	
	@FindBy(xpath=".//*[@id='checkout-form']/footer/button")
	WebElement savebutton;
	
	@FindBy(xpath="//*[@href='/User/UserEdit?custid=55&UserId=113']")
	WebElement EDITUSER;
	
	@FindBy(xpath="//*[@href='/User/UserDelete?userid=113&gstin=235']")
	WebElement DELETEUSER;
	
	@FindBy(xpath="//*[@href='/user/updation']")
	WebElement Blockandunblockuser;
	
	@FindBy(xpath="//*[@title='Block & Unblock User']")
	WebElement Block_and_unblockUserMenu;
	
	@FindBy(xpath=".//h2[text()='Block & Unblock User']")
	WebElement Block_andUnblock_PageTitle;
	

	@FindBy(xpath="//*[text()=' Block ']")
	WebElement Block;

	@FindBy(xpath=".//table[@class='table']/tbody/tr")
	List<WebElement> roleList;
	
	@FindBy(xpath=".//button[@class='confirm btn btn-lg btn-primary']")
	WebElement confirmButton;
	
	
	Screenshot screenshot=new Screenshot();
 
 /**
  * Create a Constructor and call the function value
  * @param driver
  */
public Users(WebDriver driver)
{ 
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
}



/**
 * @Method:User Menu Click
 * @return
 * @throws InterruptedException 
 */
public Boolean USER_Menu_Click() throws InterruptedException
{
	if(!(Menu_Role_Creation.isDisplayed()))
	{
		User_Master_Menu.click();
		
		Thread.sleep(2000);
		
		if(Menu_Role_Creation.isDisplayed())
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
 * @Method:Role Creation Menu Click
 * @return
 * @throws InterruptedException 
 */
public Boolean Role_Creation_menuClick() throws InterruptedException
{
	Boolean res=USER_Menu_Click();
	if(res)
	{
		Thread.sleep(2000);
		Menu_Role_Creation.click();
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.RoleCreationPage)))
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
 * Method:Add the Roles
 * @param EnterRoleName
 * @return
 * @throws InterruptedException
 */


public Boolean Add_Roles(String EnterRoleName,String Expected) throws InterruptedException
{
	Boolean res=Role_Creation_menuClick();
	if(res)
	{
		
		Thread.sleep(1000);
		EnterRole.clear();
		EnterRole.sendKeys(EnterRoleName);
		
		ClickonAddRole.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		
		if(CommonFunctions.isAlertPresent(driver))
		{
			if(driver.switchTo().alert().getText().equals("Role name already exists..!"))
			{
				driver.switchTo().alert().accept();
				return false;
			}
		}
		
		
		
		
		Thread.sleep(7000);
		WebElement roleName=driver.findElement(By.xpath(".//a[text()='"+EnterRoleName+"']"));
		roleName.click();
		Thread.sleep(1000);
	
		
		
		if(CheckboxClick.isDisplayed())
		{  
			
			CheckboxClick.click();		
			JavascriptExecutor jsc = (JavascriptExecutor)driver;
			 for(int i=1;i<=3;i++)
			    {
			    jsc.executeScript("window.scrollBy(0,500)","Update");
			   }
				
			 Update.click();
				
				WebDriverWait wait=new WebDriverWait(driver, 10000);
				wait.until(ExpectedConditions.alertIsPresent());
			
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
				Thread.sleep(10000);
				if(driver.switchTo().alert().getText().equals("Resources Updated Successfully..!"))
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
	
	return false;	
}


public Boolean Delete_Roles(String RoleName,String Expected) throws InterruptedException
{
	Boolean res=Role_Creation_menuClick();
	if(res)
	{
		Thread.sleep(2000);
		if(roleList.size() > 2)
		{
			for(int i=3;i<=roleList.size();i++)
			{
				
				if(driver.findElement(By.xpath(".//table[@class='table']/tbody/tr["+i+"]/td[1]/a")).getText().equalsIgnoreCase(RoleName))
				{
					WebElement deleteButton=driver.findElement(By.xpath(".//table[@class='table']/tbody/tr["+i+"]/td[2]/label/a"));
					deleteButton.click();
					
					System.out.println("True");
					
					if(CommonFunctions.isAlertPresent(driver))
					{
						if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Delete?"))
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
	return res;
}

/**
 * Method:Click on the User_Registration_Page
 * @return
 * @throws InterruptedException 
 */
public Boolean User_Registration_menuClick() throws InterruptedException
{
	Boolean res=USER_Menu_Click();
	if(res)
	{
		UserRegistration_Menu.click();
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.UserRegistrationPage)))
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
 * @Method:Add the Details to be filled
 * @param Nameofcustomer
 * @param designation
 * @param email
 * @param password
 * @param mobilenumber
 * @return
 * @throws InterruptedException
 */
public Boolean User_RegistrationPage(String Nameofcustomer,String designation, String email, String password, String mobilenumber, String roleName, String GSTN, String Expected) throws InterruptedException
{
	Boolean res=User_Registration_menuClick();
	if(res)
	{
		UserRegistration_Menu.click();
		
		NameofCustomer.clear();
		NameofCustomer.sendKeys(Nameofcustomer);
		
		Designation.clear();
		Designation.sendKeys(designation);
		
		
		EmailId.clear();
		EmailId.sendKeys(email);
		
		Password.clear();
		Password.sendKeys(password);
		
		Mobilenumber.clear();
		Mobilenumber.sendKeys(mobilenumber);
		
		if(SelectRole.isDisplayed())
		{
		Select selectdropdown= new Select(SelectRole);
		selectdropdown.selectByVisibleText(roleName);
		}
		 if(SelectGSTIN.isDisplayed())
		{
			Select selectdropdown= new Select(SelectGSTIN);
			selectdropdown.selectByVisibleText(GSTN);;
		}
		else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
		 
		 RegisterUser.click();
		 if(CommonFunctions.isAlertPresent(driver))
		 {
			 if(driver.switchTo().alert().getText().equalsIgnoreCase("Mobile Number or Email Id already exist."))
				{
					driver.switchTo().alert().accept();
					 screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
					 return false;
				}
			 else if(driver.switchTo().alert().getText().equalsIgnoreCase("User Registration Done Successfully "))
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
 * @Method:Search the User by name,Designation,ID
 * @param SearchType
 * @param Searchvalue
 * @return
 * @throws Exception
 */
public Boolean SearchUserName(String SearchType,String Searchvalue) throws Exception
{
//	Select selectdropdown= new Select(this.SearchType);
//	selectdropdown.selectByVisibleText(SearchType);
//	Thread.sleep(2000);
	
	Searchtext.clear();
	Thread.sleep(3000);	
	Searchtext.sendKeys(Searchvalue);
	
//	Thread.sleep(3000);		
//	SearchButton.click();
	
//	System.out.println("Search Textbox value"+ Searchtext.getText());
	
	if(resultList.size()==1 & !(resultList.get(0).getText().equalsIgnoreCase("No matching records found")))
		return true;
	else
	{
		screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
		return false;
	}
		
	
	}


/**
 * @Method:Edit all the UserName Details
 * @param editby
 * @param Name
 * @param designation
 * @param email
 * @param password
 * @param mobilenumber
 * @return
 * @throws Exception
 */

public Boolean Edit_Username(String editby,String Name,String designation,String email, String password, String mobilenumber ,String Expected) throws Exception
{
	Boolean res=User_Registration_menuClick();
	if(res)
	{

		res=SearchUserName("Designation", editby);
//	    System.out.println("Result of search :"+res);
	    
	    if(res)
		{
	    	editbutton.click();
			Thread.sleep(1000);
			if(confirmationPopUp.getText().equalsIgnoreCase("Are you sure that you want to Edit this Record?"))
			{
				buttonOnPopUp.click();
				
				Thread.sleep(1000);
				
				NameofCustomer.clear();
				Thread.sleep(1000);
				NameofCustomer.sendKeys(Name);
				Thread.sleep(1000);
				
			
				
				savebutton.click();
				if(CommonFunctions.isAlertPresent(driver))
				{
					if(driver.switchTo().alert().getText().equalsIgnoreCase("User Updated Successfully"))
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
	 else
		{
			screenshot.getScreenShot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			return false;
		}
	    
}


/**
 * Method:Delete all the User Details
 * @param Designation_Number
 * @return
 * @throws Exception
 */
public boolean Delete_User_Details(String Designation_Number) throws Exception
{
	Boolean res=User_Registration_menuClick();
		if(res)
		{
			res=SearchUserName("Designation", Designation_Number);
			//System.out.println("Result of search :"+res);
			if(res)
			{
				deleteButton.click();
				Thread.sleep(1000);
				if(confirmationPopUp.getText().equalsIgnoreCase("Are you sure that you want to delete this Record?"))
				{
					buttonOnPopUp.click();
					
					Thread.sleep(2000);
					
					if(confirmationPopUp.getText().contains("User Deleted Successfully."))
					{
						confirmButton.click();
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



/**
 * Click on the Block and UnBlock Menu
 * @return
 * @throws InterruptedException 
 */
public Boolean Block_and_UnBlock_User_menuClick() throws InterruptedException
{
	Boolean res=USER_Menu_Click();
	if(res)
	{
		Block_and_unblockUserMenu.click();
		if(driver.getTitle().equalsIgnoreCase(LoadConstantsData.readData(Constants.BlockAndUnBlockUserPage)))
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
 * Method:Block and unblock the Users
 * @param editby
 * @return
 * @throws Exception
 */
public Boolean BlockandUnblockUser(String Username, String Expected) throws Exception
{
	Boolean res=Block_and_UnBlock_User_menuClick();
	if(res)
	{

		res=SearchUserName("User Name", Username);
	    System.out.println("Result of search :"+res);
	    if(res)
		{
	    	Block.click();
			Thread.sleep(1000);
			if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Block?"))
			{
				driver.switchTo().alert().accept();
				
				Thread.sleep(2000);	
				if(driver.switchTo().alert().getText().equalsIgnoreCase("User Blocked Successfully"))
				{
					driver.switchTo().alert().accept();
					Thread.sleep(2000);
					return true;
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
	return res;
	    
}


/*
*//**
 * Method:Click on the TRP_RegistrationPage
 * @return
 * @throws InterruptedException 
 *//*
public Boolean TRP_Registration_menuClick() throws InterruptedException
{
	Boolean res=USER_Menu_Click();
	if(res)
	{
		TRP_Registration_Menu.click();
		if(TRP_Registration_PageTitle.isDisplayed() || TRP_Registration_PageTitle.getText().contains("Users Registration"))
		{
			return true;
		}
		else
			return false;
	}
	else
	return false;
	
}


*//**
 * Method:Enter the Details by adding Mandatory Fields
 * @param TRPID
 * @param TRPNAME
 * @param TRPEmail
 * @param mobilenumber
 * @return
 * @throws InterruptedException
 *//*
public Boolean TRP_RegistrationPage(String TRPID,String TRPNAME, String TRPEmail, String mobilenumber) throws InterruptedException
{
	Boolean res=TRP_Registration_menuClick();
	if(res)
	{
		
		
		TRP_ID.clear();
		TRP_ID.sendKeys(TRPID);
		
		TRP_NAME.clear();
		TRP_NAME.sendKeys(TRPNAME);
		
		
		TRP_Email.clear();
		TRP_Email.sendKeys(TRPEmail);
		
		TRP_MobileNumber.clear();
		TRP_MobileNumber.sendKeys(mobilenumber);
		
	
		Register_TRP.click();
		 
		 if(driver.switchTo().alert().getText().equals("TRP Registered Successfully"))
			{
				driver.switchTo().alert().accept();
			
			}
		 
}
	
	return false;
	}


*//**
 * @@Method:Edit_TRP_Details
 * @param editby
 * @param id
 * @param name
 * @param email
 * @param mobilenumber
 * @return
 * @throws Exception
 *//*
public Boolean EDIT_TRPDetails(String editby,String id,String name,String email,String mobilenumber ) throws Exception
{
	Boolean res=TRP_Registration_menuClick();
	if(res)
	{

		res=SearchUserName("TRP Name", editby);
	    System.out.println("Result of search :"+res);
	    
	    if(res)
		{
	    	editbutton.click();
			Thread.sleep(1000);
			if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Edit?"))
			{
				driver.switchTo().alert().accept();
				
				Thread.sleep(2000);
				NameofCustomer.clear();
				Thread.sleep(1000);
				NameofCustomer.sendKeys(name);
				Thread.sleep(1000);
	
				savebutton.click();
				
				if(driver.switchTo().alert().getText().equalsIgnoreCase("User Updated Successfully"))
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
	return false;
}


*//**
 *@Method:Delete_TRP_Details Deleting the Details 
 * @param TRP_NAME
 * @return
 * @throws Exception
 *//*
public boolean Delete_TRP_Details(String TRP_NAME) throws Exception
{
	Boolean res=TRP_Registration_menuClick();
		if(res)
		{
			res=SearchUserName("TRP Name", TRP_NAME);
			System.out.println("Result of search :"+res);
			if(res)
			{
				Deletebutton.click();
				Thread.sleep(1000);
				if(driver.switchTo().alert().getText().equalsIgnoreCase("Are you sure to Delete?"))
				{
					driver.switchTo().alert().accept();
					
					Thread.sleep(2000);
					
					if(driver.switchTo().alert().getText().contains("User Deleted Successfully"))
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
		return false;
}
*/


}

