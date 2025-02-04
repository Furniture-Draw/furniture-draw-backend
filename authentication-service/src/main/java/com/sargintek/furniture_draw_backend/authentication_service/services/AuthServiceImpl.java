package com.sargintek.furniture_draw_backend.authentication_service.services;

import com.sargintek.furniture_draw_backend.user_service.entity.Entity;
import com.sargintek.furniture_draw_backend.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;


    public AuthServiceImpl(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;

    }

    @Override
    public String login(String email, String rawPassword) {
        try {
            // Find user by email
            Entity user = userRepository.findByEmail(email)
                    .orElse(null);

            if (user == null) {
                return "Invalid email or password.";
            }

            String encodedPassword = user.getPassword();

            boolean isPasswordMatch = passwordService.matches(rawPassword, encodedPassword);

            if (!isPasswordMatch) {
                return "Invalid email or password.";
            }

            return "Login successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Login failed. Please try again.";
        }
    }
    @Override
    public String register(String username, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            return "This email is already registered!";
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
        return userRepository.findAll();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}


