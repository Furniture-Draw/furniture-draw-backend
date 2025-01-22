package com.sargintek.furniture_draw_backend.authentication_service.services;


import com.sargintek.furniture_draw_backend.authentication_service.entity.Entity;
import com.sargintek.furniture_draw_backend.authentication_service.repository.UserRepositoryy;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepositoryy userRepository;
    private final PasswordService passwordService;

    public AuthServiceImpl(UserRepositoryy userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public String login(String email, String password) {
        Optional<Entity> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return "Kullanıcı bulunamadı!";
        }

        Entity user = userOptional.get();
        if (passwordService.matches(password, user.getPassword())) {
            return "Giriş başarılı!";
        } else {
            return "Şifre hatalı!";
        }
    }

    @Override
    public String register(String username, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            return "Bu e-posta zaten kayıtlı!";
        }

        String encodedPassword = passwordService.encodePassword(password);
        Entity newUser = new Entity(username, encodedPassword, email);
        userRepository.save(newUser);

        return "Kayıt başarılı!";

    }

    @Override
    public String logout(String token) {
        return "";
    }

    @Override
    public String forgotPassword(String email) {
        return "";
    }

    @Override
    public List<Entity> getAllUsers() {
        return List.of();
    }
}
