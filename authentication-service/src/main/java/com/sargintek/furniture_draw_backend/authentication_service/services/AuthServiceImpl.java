package com.sargintek.furniture_draw_backend.authentication_service.services;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String username, String password) {
        return username + " " + password;
    }

    @Override
    public String register(String username, String password) {
        return "";
    }

    @Override
    public String logout(String token) {
        return "";
    }

    @Override
    public String forgotPassword(String username) {
        return "";
    }
}
