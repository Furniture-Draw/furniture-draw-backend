package com.sargintek.furniture_draw_backend.authentication_service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("deniznuman25@gmail.com");
        mailSender.setPassword("xiqd yxfv vxiv jqnx");  // Uygulama şifresini kullanın
        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}

