package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metacube.training.model.User;

@Service
public class EmailService {
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(User user){
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmailAddress());
		mail.setFrom("aakankshametacube@gmail.com");
		mail.setSubject("FORGET PASSWORD");
		String message = "Hello " + user.getFirstName()+" " + user.getLastname() +"\n" + "please click below link to reset your password:\n\n" + user.getAppUrl();
		mail.setText(message);
		javaMailSender.send(mail);
	}
}
