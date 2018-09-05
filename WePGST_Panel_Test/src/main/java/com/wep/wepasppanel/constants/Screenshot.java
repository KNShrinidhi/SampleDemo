package com.wep.wepasppanel.constants;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Screenshot{
	
	public WebDriver driver;
	
	String folder_name;
	String path=LoadConstantsData.readData(Constants.GeneralPath);
	public static String ScreenShotPath=LoadConstantsData.readData(Constants.ScreenShotPath);
	
	private static Logger log = Logger.getLogger(Screenshot.class.getName());	
	
	public void getScreenShot(WebDriver driver, String testCase){		
		
	try{
			@SuppressWarnings("unused")
			String ScreenShot_Path = LoadConstantsData.readData(Constants.ScreenShotPath);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(path+"\\screenshots\\"+testCase+System.currentTimeMillis()+".jpg"));
		}
		catch (IOException er)
		{
			er.printStackTrace();
			System.out.println("Exception Encountered");
			log.error(er);
		} 
	}
	
	
	public void createFolder()
	{
		File file = new File("C:\\Directory1");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
	}
	
	
	
//	
//	public void screenshot() throws IOException{
////   	 File srcFile=ad.getScreenshotAs(OutputType.FILE);
////	    String filename=UUID.randomUUID().toString(); 
////	    File targetFile=new File("C:/Users/Test/Desktop/appiumworkspace/Screenshots/" + filename +".jpg");
////	 
////	    
////	    FileUtils.copyFile(srcFile,targetFile);
////
////	    System.out.println(targetFile);
//	    
//	    
//	   folder_name="sshot";
//       File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//       //create dir with given folder name
//       new File(folder_name).mkdir();
//       //Setting file name
//       String file_name=DateFormat.format( folder_name, new Date())+".png";
//       //coppy screenshot file into screenshot folder.
//       FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
//	    
//	   
//	    
//   }
	
}
