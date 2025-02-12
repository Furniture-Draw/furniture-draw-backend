package com.sargintek.furniture_draw_backend.authentication_service.services;

import com.sargintek.furniture_draw_backend.user_service.entity.Entity;
import com.sargintek.furniture_draw_backend.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.time.LocalDateTime;
import java.util.List;



@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final EmailServiceImpl emailService;


    public AuthServiceImpl(UserRepository userRepository, PasswordService passwordService, EmailServiceImpl emailService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.emailService = emailService;

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
        Entity newUser = new Entity(username, encodedPassword, email );
        userRepository.save(newUser);

        return "Kayıt başarılı!";
    }
    @Override
    public String forgotPassword(String email) {
        Entity user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "User with this email not found.";
        }

        String resetToken = UUID.randomUUID().toString();

        user.setResetToken(resetToken);
        user.setResetTokenUsed(false);
        user.setResetTokenExpiration(LocalDateTime.now().plusMinutes(5));

        userRepository.save(user);

        // Create reset link
        String resetLink = "http://localhost:3000/resetpassword?email=" + email + "&token=" + resetToken;
        emailService.sendResetPasswordEmail(email, resetLink);

        return "Reset link has been sent to your email.";
    }

    @Override
    public String resetPassword(String email, String token, String newPassword) {
        Entity user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "Invalid email or reset request";
        }

        if (token == null ||
                !token.equals(user.getResetToken()) ||
                user.isResetTokenUsed()) {
            return "Invalid or used reset token";
        }


        if (user.getResetTokenExpiration() == null ||
                LocalDateTime.now().isAfter(user.getResetTokenExpiration())) {
            return "Reset token has expired";
        }

        String encodedPassword = passwordService.encodePassword(newPassword);
        user.setPassword(encodedPassword);

        user.setResetToken(null);
        user.setResetTokenUsed(true);
        user.setResetTokenExpiration(null);
        userRepository.save(user);

        return "Password reset successful";
    }

    @Override
    public String logout(String token) {
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


