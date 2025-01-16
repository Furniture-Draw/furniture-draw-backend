package com.sargintek.furniture_draw_backend.authentication_service.services;

public interface AuthService {
    // It should return token after successfully login
    String login(String username, String password);
    // It should return token after successfully register
    String register(String username, String password);
    String logout(String token);
    String forgotPassword(String username);
}
