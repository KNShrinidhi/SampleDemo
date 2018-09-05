package com.wep.wepasppanel.constants;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions 
{
	public static boolean isAlertPresent(WebDriver driver)
	{
	try{
	
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		Alert element = wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		
		return true;
		
		}
		catch(NoAlertPresentException ex)
		{
	
		return false;
		}
	}
}
