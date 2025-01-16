package com.sargintek.furniture_draw_backend.authentication_service.services;

public interface TokenService {
    String generateToken(String username);
    boolean validateToken(String token);
    String getUsernameFromToken(String token);
}
