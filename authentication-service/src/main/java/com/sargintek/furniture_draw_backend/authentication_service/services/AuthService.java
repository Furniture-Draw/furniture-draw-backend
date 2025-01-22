package com.sargintek.furniture_draw_backend.authentication_service.services;

<<<<<<< HEAD
import com.sargintek.furniture_draw_backend.authentication_service.entity.Entity;

import java.util.List;

public interface AuthService {
    // It should return token after successfully login
    String login(String email, String password);
    // It should return token after successfully register
    String register(String username,String email, String password);
    String logout(String token);
    String forgotPassword(String email);
    List<Entity> getAllUsers();
=======
public interface AuthService {
    // It should return token after successfully login
    String login(String username, String password);
    // It should return token after successfully register
    String register(String username, String password);
    String logout(String token);
    String forgotPassword(String username);
>>>>>>> 946c2f699ce48a2078b29f19f51e702a9dbb372c
}
