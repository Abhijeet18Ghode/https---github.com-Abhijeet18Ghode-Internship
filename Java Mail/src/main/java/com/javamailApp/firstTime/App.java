package com.javamailApp.firstTime;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class App 
{
    public static void main( String[] args )
    {
       String  message="Hello dear student.....!";
       String subject="Last call from....!";
       String to="myabhyasika@gmail.com";
       String from="ghodeabhijeet18@gmail.com";
       
       SendMail(message,subject,to,from);
    }

	private static void SendMail(String message, String subject, String to, String from) {
		String host="smtp.gmail.com";
		
		
		Properties properties = System.getProperties();
		System.out.println(properties);
		
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);
		
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("ghodeabhijeet18@gmail.com", "jopy blsv xxpm gvpf");
			}
		
			
			
		});
		session.setDebug(true);
		
		
		MimeMessage m = new MimeMessage(session);
		
		try {
		m.setFrom(from);
		m.addRecipient(RecipientType.TO, new InternetAddress(to));
		m.setSubject(subject);
		m.setText(message);
		
		Transport.send(m);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


















