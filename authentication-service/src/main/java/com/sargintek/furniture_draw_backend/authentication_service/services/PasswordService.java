package com.sargintek.furniture_draw_backend.authentication_service.services;

public interface PasswordService {

    String encodePassword(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
