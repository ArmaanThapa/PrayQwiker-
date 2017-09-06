package com.qwikr.webapi.mail;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.qwikr.webapi.domain.User;
import com.qwikr.webapi.service.UserService;

public class Email {
	
	@Autowired
	UserService userService;
	
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_AUTH_USER = "gsrikanth831@gmail.com";
	private static final String SMTP_AUTH_PWD = "Srikanth@123";
	final String protNumber = "587";


	public void sendMail(User user,String emailTo, String recipients[], String subject, String message, String from)
	throws MessagingException, AuthenticationFailedException {
	
		Properties props = new Properties();
		props.put("mail.smtp.user",SMTP_AUTH_USER); 
		props.put("mail.smtp.host", SMTP_HOST_NAME); 
		props.put("mail.smtp.port", "587"); 
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.EnableSSL.enable","true");

		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.put("mail.smtp.socketFactory.fallback", "false");   
	
		props.setProperty("mail.smtp.socketFactory.port", "465"); 
		
	
		try {

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
				}
			});

			Message msg = new MimeMessage(session);

			InternetAddress addressFrom = new InternetAddress(from);
			msg.setFrom(addressFrom);

			InternetAddress[] emailToArr = new InternetAddress[1];
			emailToArr[0] = new InternetAddress(emailTo);
			System.out.println("emailTo---" + emailTo);
			msg.setRecipients(Message.RecipientType.TO, emailToArr);

			msg.setSubject(subject);
			msg.setContent(message, "text/plain");
			Transport.send(msg);
			userService.update(user);
		} catch (Exception e) {
			System.err.println("Error Occured while Sending EMail :" + e.getMessage());
		}
	}
	//********************************************
	
}
