package org.oregami.service;

import java.io.IOException;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUsingAuthentication {
	private static String SMTP_AUTH_USER ;
	private static String SMTP_AUTH_PWD ;
	
	public boolean postMail(String recipients[], String subject, String message, String from) throws MessagingException,
			AuthenticationFailedException {
		
		Properties mailProperties = new Properties();
		try {
			mailProperties.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		boolean debug = false;
		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", mailProperties.get("mail.smtphost"));
		props.put("mail.smtp.auth", "true");
		
		SMTP_AUTH_USER = (String) mailProperties.get("mail.username");
		SMTP_AUTH_PWD = (String) mailProperties.get("mail.password");
		
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(debug);
		// create a message
		Message msg = new MimeMessage(session); // set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
		return true;
		
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}

}
