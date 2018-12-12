package com.free_calendar_system.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService  {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(
      ) {
       
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("facundo.ferro@globallogic.com"); 
        message.setSubject("test"); 
        message.setText("test");
        emailSender.send(message);
       
    }
}