package com.qwikr.webapi.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwikr.webapi.dao.AdminDao;
import com.qwikr.webapi.domain.Admin;
import com.qwikr.webapi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

/*	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}
*/
	public List<Admin> getAdminList() {
		return adminDao.getAdminList();
	}

	public List<Admin> getAdminMobilenumber(String mobilenumber) {
		return adminDao.getAdminMobilenumber(mobilenumber);

	}

	public List<Admin> checkAdminMobilenumber(String mobilenumber) {
		return adminDao.checkAdminMobilenumber(mobilenumber);
	}

	public List<Admin> checkAdminEmail(String email) {
		return adminDao.checkAdminEmail(email);
	}

	public List<Admin> getAdminEmail(String email) {
		return adminDao.getAdminEmail(email);
	}

	public List<Admin> getAdminOrganization(String organization) {
		return adminDao.getAdminOrganization(organization);
	}
	public List<Admin> checkAdminOrganization(String organization){
		return adminDao.checkAdminOrganization(organization);
	}
	public List<Admin> getEmailAndPassword(String email, String password){
		return adminDao.getEmailAndPassword(email, password);
	}
	public void verifyAdminAccount(String vcode,String email){
		adminDao.verifyAdminAccount(vcode, email);
	}
	public String addAdmin(Admin admin,HttpServletRequest req,HttpServletResponse res) {
		synchronized (admin) {
			long code = System.currentTimeMillis();
			String vcode = "AK" + code + "Kt";
			String message = "Welcome " + admin.getFirstname() + "," + "\n"
					+ "Thank you for signing up....Enjoy our services.."
					+ "enter the following code to access our services." + "\n" + " Verification Code : " + vcode;
			String subject = "Welcome .." + admin.getFirstname();
			// ----------------------------
			final String SMTP_HOST_NAME = "smtp.gmail.com";
			final String SMTP_AUTH_USER = "gsrikanth831@gmail.com";
			final String SMTP_AUTH_PWD = "Srikanth@123";
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

				String from = "gsrikanth831@gmail.com";
				Message msg = new MimeMessage(session);

				InternetAddress addressFrom = new InternetAddress(from);
				msg.setFrom(addressFrom);
				InternetAddress[] emailToArr = new InternetAddress[1];
				emailToArr[0] = new InternetAddress(admin.getEmail());
				System.out.println("emailTo---" + admin.getEmail());
				msg.setRecipients(Message.RecipientType.TO, emailToArr);
				msg.setSubject(subject);
				msg.setContent(message, "text/plain");
				Transport.send(msg);
				admin.setVerificationcode(vcode);
				admin.setVerificationstatus(false);
				adminDao.addAdmin(admin);
			} catch (Exception e) {
				System.err.println("Error Occured");
				System.err.println("Error Occured While Sending Email : " + e.getMessage());
				//RequestDispatcher rd = req.getRequestDispatcher("/Static/500.jsp");
				//rd.forward(req, res);
				return "/Static/500";
			}

			/*user.setVerificationcode(vcode);
			user.setVerificationstatus(false);
			dao.add(user);*/
		}
		return "";
	}
	
	public List<Admin> getbyVerificationcode(String vcode){
		return adminDao.getbyVerificationcode(vcode);
	}
}
