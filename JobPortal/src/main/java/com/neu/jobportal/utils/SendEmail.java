package com.neu.jobportal.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendEmail {
	@Autowired
	ServletContext servletContext;
	
	public void sendEmail(JavaMailSender mailSender, String recipient, String subject, String message) throws MessagingException {
		    
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("manish.patil5191@gmail.com");
        email.setTo(recipient);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
//		JavaMailSenderImpl sender = new JavaMailSenderImpl();
//		sender.setHost("smtp.gmail.com");
//		sender.setPort(587);
//		sender.setJavaMailProperties(mail.smtp.starttls.enable=true);
//		MimeMessage msg = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(msg);
//		helper.setFrom("manish.patil5191@gmail.com");
//		helper.setTo(recipient);
//		helper.setText("Thank you!");
//		sender.send(msg);
	 }
}
