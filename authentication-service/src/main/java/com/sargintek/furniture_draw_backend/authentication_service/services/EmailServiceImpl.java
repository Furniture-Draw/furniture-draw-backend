package com.sargintek.furniture_draw_backend.authentication_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;  // JavaMailSender kullanarak e-posta gönderimi yapıyoruz

    @Override
    public void sendResetPasswordEmail(String Email, String resetToken) {
        // E-posta içeriğini oluşturuyoruz
        String subject = "Password Reset Request";
        String message = "To reset your password, please use the following token: " + resetToken;

        sendEmail(Email, subject, message);
    }

    private void sendEmail(String Email, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(Email);
        email.setSubject(subject);
        email.setText(message);
        email.setFrom("deniznuman25@gmail.com");

        try {
            emailSender.send(email);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
