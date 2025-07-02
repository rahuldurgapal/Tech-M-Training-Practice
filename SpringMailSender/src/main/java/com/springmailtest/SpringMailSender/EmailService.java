package com.springmailtest.SpringMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailVerification(String toEmail, String token) {
        String subject = "Emaill Verification";
        String verificationUrl = "http://localhost:8080/verify?token=" + token;
        String body = "Click the link to verify your email "  + verificationUrl;

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setSubject(subject);
        mail.setTo(toEmail);
        mail.setText(body);


        mailSender.send(mail);

    }
}
