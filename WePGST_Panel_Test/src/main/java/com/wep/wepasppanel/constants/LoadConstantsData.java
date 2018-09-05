package com.wep.wepasppanel.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author KK
 *
 */
public class LoadConstantsData 
{
		static Properties properties;
		String fileName="D:\\Project\\GST\\Automation\\GST_Automation\\config.properties";
		/**
		 * Constructor
		 */
		public LoadConstantsData() {
	 
			try {
				FileInputStream Locator = new FileInputStream(fileName);
				properties = new Properties();
				properties.load(Locator);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 
		}
	 
		/**
		 * @param ElementName
		 * @return
		 * @throws Exception
		 */
		public static String getData(String ElementName) throws Exception
		{
			System.out.println(ElementName);
			// Read value using the logical name as Key
			String data = properties.getProperty(ElementName);
			System.out.println(ElementName);
			return data;
		}

		 /**
		 * @param key
		 * @return
		 */
		public static String readData(String key) {
	           String value = "";
	           try {

	                         Properties properties = new Properties();
	                         File file  = new File("config.properties");
	                         if (file.exists()) {
	                                             properties.load(new FileInputStream(file));
	                                             value = properties.getProperty(key);
	                        }
	            } catch (Exception e) {
	                        System.out.println(e);
	            }
	           return value;
	    }
}
