package com.wep.wepasppanel.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.wep.wepasppanel.constants.Constants;
import com.wep.wepasppanel.constants.LoadConstantsData;

/**
 * @author KK
 *
 */
public class Browser_Initialization 
{
	//String browserName=LoadConstantsData.readData(Constants.Browsername);
	public String browserName=System.getProperty("browserName");
	public String path=System.getProperty("path");
	public String url=System.getProperty("url");
	public WebDriver driver;
	
//	String path=LoadConstantsData.readData(Constants.GeneralPath);
//	String browserName=LoadConstantsData.readData(Constants.Browsername);
//	String url=LoadConstantsData.readData(Constants.Url);
	public SoftAssert softassert1= new SoftAssert();
	
	/**
	 * Browser initialization  
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeSuite
	//@BeforeClass
	
	public void initialization() throws Exception
	{
//		System.out.println("browserName "+browserName);
//		System.out.println("url "+url);
//		System.out.println("Path "+path+LoadConstantsData.readData(Constants.FF_DriverPath));
		if(browserName.equalsIgnoreCase("FF"))
		{
     		System.setProperty(LoadConstantsData.readData(Constants.FF_DriverName), path+LoadConstantsData.readData(Constants.FF_DriverPath));
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("GC"))
		{
			System.setProperty(LoadConstantsData.readData(Constants.GC_DriverName), path+LoadConstantsData.readData(Constants.GC_DriverPath));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			
			driver = new ChromeDriver(options);
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty(LoadConstantsData.readData(Constants.IE_DriverName), path+LoadConstantsData.readData(Constants.IE_DriverPath));
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, Constants.Url);
			driver = new InternetExplorerDriver(ieCaps);
		}
		driver.get(url);
	}
	
    /** 
     * Browser Closing function
     */
    @AfterSuite
	public void browserclose()
	{
		driver.close();
//		try {
//			SendEmail.sentmail();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
