package com.sargintek.furniture_draw_backend.authentication_service.services;

public interface EmailService {
    void sendResetPasswordEmail(String Email, String resetToken);
}
