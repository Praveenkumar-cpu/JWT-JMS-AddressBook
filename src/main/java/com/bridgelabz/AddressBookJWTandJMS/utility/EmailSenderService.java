package com.bridgelabz.AddressBookJWTandJMS.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,String subject,String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("praveenpkbadiger@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);
        mailSender.send(mailMessage);
        System.out.println("Mail Send to the User");
    }

}
