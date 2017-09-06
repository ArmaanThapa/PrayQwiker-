/**
 * 
 */
package com.qwikr.webapi.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.qwikr.webapi.dao.Userdao;
import com.qwikr.webapi.domain.User;

/**
 * @author Srikanth
 *
 */
public class RegisterEmail {
	@Autowired
	Userdao dao;
	public String sendMail(User user,HttpServletRequest req,HttpServletResponse res){// throws ServletException, Exception {
		synchronized (user) {
			long code = System.currentTimeMillis();
			String vcode = "VQ" + code + "mS";
			String message = "Welcome " + user.getFirstname() + "," + "\n"
					+ "Thank you for signing up....Enjoy our services.."
					+ "enter the following code to access our services." + "\n" + " Verification Code : " + vcode;
			String subject = "welcome .." + user.getFirstname();
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
				System.err.println("Error Occured While Sending Email : " + e.getMessage());
				//RequestDispatcher rd = req.getRequestDispatcher("/Static/500.jsp");
				//rd.forward(req, res);
				return "/Static/500";
			}

			user.setVerificationcode(vcode);
			user.setVerificationstatus(false);
			dao.add(user);
		}
		return "";
	}

}
