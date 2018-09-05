package com.wep.wepasppanel.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail {
		
	   public static void sentmail() throws Exception
       {
		  
//		   // Recipient's email ID needs to be mentioned.
//		   String to = "krishnamoorthy@bvbi-infotech.com";
////          String to = "balaji.y@bvbi-infotech.com";
//          String cc="kishore.jinka@bvbi-infotech.com";
//          // Sender's email ID needs to be mentioned
		   
			   
         final String fromEmailId = LoadConstantsData.readData(Constants.fromEmailID);
        final  String fromEmailPsw=LoadConstantsData.readData(Constants.fromEmailPassword);
          String toEmailIDs=LoadConstantsData.readData(Constants.toEmailIDs);
          String bccEmailIDs=LoadConstantsData.readData(Constants.bccEmailIDs);
          String emailSubject=LoadConstantsData.readData(Constants.emailSubject);
          String emailContent=LoadConstantsData.readData(Constants.emailContent);;
          String attachmentPath=LoadConstantsData.readData(Constants.GeneralPath)+LoadConstantsData.readData(Constants.attachmentPath);

//          final String username = "customerconnect@bvbi-infotech.com";//change accordingly
//          final String password = "ccbvbi@123";//change accordingly

          // Assuming you are sending email through relay.jangosmtp.net
//          String host = "smtpout.secureserver.net";

          Properties props = new Properties();
          
          props.put("mail.smtp.host", "smtp.office365.com");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "587");
          props.put("mail.debug", "true");
          props.put("mail.smtp.starttls.enable", "true");
          
          
          
          
          
          
         // props.put("mail.store.protocol", "SMTP"); //SMTP Host
//          props.put("mail.smtp.port", "587");
//          props.put("mail.smtp.host","smtp.office365.com");
//          props.put("mail.smtp.starttls.enable", "false");
//          props.put("mail.smtp.auth", "true");
//          props.put("mail.debug", "true");
          
//          props.put("mail.smtp.host", "smtp.office365.com"); //SMTP Host
//  		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
//  		props.put("mail.smtp.socketFactory.class",
//  				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//  		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
//  		props.put("mail.smtp.port", "587"); //SMTP Port
//  		props.put("mail.debug", "true"); // Debug mode
          Session session = Session.getDefaultInstance(props,  
           new javax.mail.Authenticator() {  
           protected PasswordAuthentication getPasswordAuthentication() {  
        	   return new PasswordAuthentication(fromEmailId,fromEmailPsw);//change accordingly  
//           return new PasswordAuthentication("krishnamurthy.karanth@wepdigital.com","karanth@123");//change accordingly  
           }  
          });  

          try {
             // Create a default MimeMessage object.
             Message message = new MimeMessage(session);

             // Set From: header field of the header.
             message.setFrom(new InternetAddress(fromEmailId));

             // Set To: header field of the header.
   //          message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("balaji.y@bvbi-infotech.com"));
   //          message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("kishore.jinka@bvbi-infotech.com"));
   //          message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("swarupa.anand@wepindia.com"));
             message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailIDs));
             message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccEmailIDs));

             // Set Subject: header field
             //message.setSubject("Automated Test Script Result");
             message.setSubject(emailSubject);
             
             // Create the message part
             BodyPart messageBodyPart = new MimeBodyPart();

             // Now set the actual message
             //messageBodyPart.setText("Hi Sir/Madam ,\n\n\n \tPlease find the Automation Test Result in Attachment \n\n\n  Note :- Do not replay for this email, this has been sent to automated mail system.");
             messageBodyPart.setText(emailContent);
             
             // Create a multipar message
             Multipart multipart = new MimeMultipart();

             // Set text message part
             multipart.addBodyPart(messageBodyPart);

             // Part two is attachment
             
             messageBodyPart = new MimeBodyPart();
             //String filename = "D:\\Project\\GST\\Automation\\Wepgst_portal\\test-output\\emailable-report.html";
             
             DataSource source = new FileDataSource(attachmentPath);
             messageBodyPart.setDataHandler(new DataHandler(source));
             System.out.println(attachmentPath.substring(attachmentPath.lastIndexOf("\\")+1));
             messageBodyPart.setFileName(attachmentPath.substring(attachmentPath.lastIndexOf("\\")+1));
             multipart.addBodyPart(messageBodyPart);
             
             // Send the complete message parts
             message.setContent(multipart,"text/html;charset=\\\"ISO-8859-1\\");
            
             // Send message
             Transport.send(message);
      

             System.out.println("Sent message successfully....");
      
          } 
          catch (MessagingException e) 
          {
             throw new Exception(e);
          }
         
      }
	  
	   public static void initiateZipping() throws IOException
	   {
		   File directoryToZip = new File("D:\\CustomerConnect\\Automation\\CustomerConnect\\UI\\GraphicalReport");

			List<File> fileList = new ArrayList<File>();
			System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
			getAllFiles(directoryToZip, fileList);
			System.out.println("---Creating zip file");
			writeZipFile(directoryToZip, fileList);
			System.out.println("---Done");
	   }
	   public static void getAllFiles(File dir, List<File> fileList) {
			try {
				File[] files = dir.listFiles();
				for (File file : files) {
					
					fileList.add(file);
					
					//System.out.println(file.getName());
					if (file.isDirectory()) {
						System.out.println("directory:" + file.getCanonicalPath());
						getAllFiles(file, fileList);
					} else {
						System.out.println("     file:" + file.getCanonicalPath());
					}
					//System.out.println(fileList.size());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void writeZipFile(File directoryToZip, List<File> fileList) throws FileNotFoundException,
		IOException {

			try {
				FileOutputStream fos = new FileOutputStream("TestNGReports.zip");
				
				ZipOutputStream zos = new ZipOutputStream(fos);

				for (File file : fileList) {
					if (!file.isDirectory()) { // we only zip files, not directories
						addToZip(directoryToZip, file, zos);
					}
				}

				zos.close();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
				IOException {

			FileInputStream fis = new FileInputStream(file);

			// we want the zipEntry's path to be a relative path that is relative
			// to the directory being zipped, so chop off the rest of the path
			String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
					file.getCanonicalPath().length());
			System.out.println("Writing '" + zipFilePath + "' to zip file");
			ZipEntry zipEntry = new ZipEntry(zipFilePath);
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}

			zos.closeEntry();
			fis.close();
		}
		
		
            
   
		
   
}