package com.qwikr.webapi.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.qwikr.webapi.dao.Userdao;
import com.qwikr.webapi.domain.User;
import com.qwikr.webapi.service.UserService;

@Service
public class userServiceImp implements UserService {

	@Autowired
	Userdao dao;
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private SimpleMailMessage preConfiguredMessage;

	public void add(User user) {
		dao.add(user);
	}// public void updateUserProfile(long uid,String fname,String lname,String
		// mobile,String email);

	public void setPassword(long uid, String password) {
		dao.setPassword(uid, password);
	}

	public void updateUserProfile(long uid, String fname, String lname) {
		dao.updateUserProfile(uid, fname, lname);
	}

	public void verifyAccount(String code, String email) {
		dao.verifyAccount(code, email);
	}

	public void update(User user) {
		dao.update(user);
	}

		public List<User> getuserByEmail(String email, String pass) {

		return dao.getuserByEmail(email, pass);
	}

	public List<User> viewAll() {
		return dao.viewAll();
	}

	public List<User> getByPassword(String password) {
		// TODO Auto-generated method stub
		return dao.getByPassword(password);
	}

	public User getById(long Id) {
		return dao.getById(Id);

	}

	public List<User> getbyVerificationcode(String verificationcode) {
		// TODO Auto-generated method stub
		return dao.getbyVerificationcode(verificationcode);
	}

	public void sendMail(User user){;//,HttpServletRequest req,HttpServletResponse res) throws ServletException, Exception {
		synchronized (user) {
			System.out.println("////////////////////////////////////////////////");
			long code = System.currentTimeMillis();
			String vcode = "VQ" + code + "MS";
			String message = "Welcome " + user.getFirstname() + "," + "\n"
					+ "Thank you for signing up....Enjoy our services.."
					+ "enter the following code to access our services." + "\n" + " Verification Code : " + vcode;
			String subject = "welcome .." + user.getFirstname();
			// ----------------------------
			final String SMTP_HOST_NAME = "smtp.gmail.com";
			final String SMTP_AUTH_USER = "paulalbert146@gmail.com";
			final String SMTP_AUTH_PWD = "146qwertyuio";
			final String protNumber = "587";

			Properties props = new Properties();
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.port", "587");
			props.put("mail.debug", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.EnableSSL.enable", "true");

			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			props.setProperty("mail.smtp.socketFactory.port", "465");
			System.out.println("///9999999999999999999987967777777777777777777777777777777777777777777777777777");

			try {

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
					}
				});

				String from = "paulalbert146@gmail.com";
				Message msg = new MimeMessage(session);
				System.out.println("9999999999999999999999999999999999999999999999999999999999999");

				InternetAddress addressFrom = new InternetAddress(from);
				msg.setFrom(addressFrom);

				InternetAddress[] emailToArr = new InternetAddress[1];
				emailToArr[0] = new InternetAddress(user.getEmailid());
				System.out.println("emailTo---" + user.getEmailid());
				msg.setRecipients(Message.RecipientType.TO, emailToArr);

				msg.setSubject(subject);
				msg.setContent(message, "text/plain");
				Transport.send(msg);
				/*user.setVerificationcode(vcode);
				user.setVerificationstatus(false);
				dao.add(user);*/
			} catch (Exception e) {
				/*HttpServletRequest request= null;
				HttpServletResponse response = null;*/
				System.err.println("Error Occured");
				System.err.println("5555555555555555555555555555555555555555555555");
				System.err.println("Error Occured While Sending Email : " + e.getMessage());
				//RequestDispatcher rd = req.getRequestDispatcher("/Static/500.jsp");
				//rd.forward(req, res);
				//return "/Static/500";
			}

			user.setVerificationcode(vcode);
			user.setVerificationstatus(false);
			dao.add(user);
		}
		//return "";
	}
	public void resendVerificationCode(String email,String code) {
			
			String message = "Dear User," + "\n"
					+ "Enter the following code to access our services." + "\n" + " Verification Code : " + code;
			String subject = "New Verification Code";
			// ----------------------------
			final String SMTP_HOST_NAME = "smtp.gmail.com";
			final String SMTP_AUTH_USER = "paulalbert146@gmail.com";
			final String SMTP_AUTH_PWD = "146qwertyuio";
			final String protNumber = "587";

			Properties props = new Properties();
			props.put("mail.smtp.user", SMTP_AUTH_USER);
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.port", "587");
			props.put("mail.debug", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.EnableSSL.enable", "true");

			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			props.setProperty("mail.smtp.socketFactory.port", "465");

			try {

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
					}
				});

				String from = "armaan@msewa.com";
				Message msg = new MimeMessage(session);

				InternetAddress addressFrom = new InternetAddress(from);
				msg.setFrom(addressFrom);

				InternetAddress[] emailToArr = new InternetAddress[1];
				emailToArr[0] = new InternetAddress(email);
				System.out.println("emailTo---" + email);
				msg.setRecipients(Message.RecipientType.TO, emailToArr);
				msg.setSubject(subject);
				msg.setContent(message, "text/plain");
				Transport.send(msg);
			} catch (Exception e) {
				System.err.println("mail sending failed:--" + e);
			}
			dao.resendVerificationCode(email, code);
		}	


	public List<User> getLoginVerification(String email, String pass, boolean vstatus) {

		return dao.getLoginVerification(email, pass, vstatus);
	}

	public void verifyEmailByCode(String code) {
		dao.verifyEmailByCode(code);
	}

	public List<User> getOldPassword(String oldpassword) {
		return dao.getOldPassword(oldpassword);
	}

	public List<User> getMobilenumber(String mobile) {
		return dao.getMobilenumber(mobile);
	}

	public List<User> getEmail(String email) {
		return dao.getEmail(email);
	}

	public List<User> getEmailAndPassword(String email, String password) {
		return dao.getEmailAndPassword(email, password);
	}

	public List<User> getUserid(long uid) {
		return dao.getUserid(uid);
	}
	public byte[] encrypt(String password) {
		return dao.encrypt(password);
	}
	
	public String decrypt(byte[] encrypted){
		return dao.decrypt(encrypted);
	}
	public void forgotPasswordMail(String email, User user){

		final String SMTP_HOST_NAME = "smtp.gmail.com";
		final String SMTP_AUTH_USER = "paulalbert146@gmail.com";
		final String SMTP_AUTH_PWD = "146qwertyuio";
		final String protNumber = "587";
		
		String subject = "Your New password";
		String message = "Don't Forget Next time ";
		String from = "paulalbert146@gmail.com";
		String emailid = "paulalbert146@gmail.com";
		
		double random1 = Math.random() * 10000;
		int random = (int) random1;
		String password = "aK" + random + "Ytu";
		
		//userService.update(uobj);
		message += " your temparory password is " + password;
		
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
					emailToArr[0] = new InternetAddress(email);
					System.out.println("emailTo---" + email);
					msg.setRecipients(Message.RecipientType.TO, emailToArr);

					msg.setSubject(subject);
					msg.setContent(message, "text/plain");
					Transport.send(msg);
					user.setPassword(password);
					user.setConfirmpassword(password);
					//dao.update(user);
					dao.forgotPasswordEmail(password, email);
					//userService.update(uobj);
				} catch (Exception e) {
					System.err.println("Error Occured while Sending EMail :" + e.getMessage());
				}
			}

	@Override
	public List<User> getEncodedPasswordByEmail(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSearchItem(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}
}