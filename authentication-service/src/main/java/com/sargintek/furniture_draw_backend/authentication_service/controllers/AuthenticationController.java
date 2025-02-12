package com.sargintek.furniture_draw_backend.authentication_service.controllers;

import com.sargintek.furniture_draw_backend.authentication_service.services.GoogleAuthServiceImpl;
import com.sargintek.furniture_draw_backend.user_service.dtos.LoginUserDto;
import com.sargintek.furniture_draw_backend.user_service.dtos.RegisterUserDto;
import com.sargintek.furniture_draw_backend.authentication_service.services.AuthService;
import com.sargintek.furniture_draw_backend.user_service.entity.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthService authService;
    private final GoogleAuthServiceImpl googleAuthService;

    public AuthenticationController(AuthService authService, GoogleAuthServiceImpl googleAuthService) {
        this.authService = authService;
        this.googleAuthService = googleAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUserDto loginUserDto) {
        try {
            String result = authService.login(loginUserDto.email(), loginUserDto.password());

            if (result.equals("Login successful")) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Login failed. Please try again.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto registerUserDto) {
        if (authService.existsByEmail(registerUserDto.email())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Bu e-posta adresi zaten kayıtlı.");
        }

        String result = authService.register(
                registerUserDto.username(),
                registerUserDto.email(),
                registerUserDto.password()
        );

        return ResponseEntity.ok(result);
    }

    @PostMapping("/google-register")
    public ResponseEntity<String> googleRegister(@RequestBody String idToken) {
        try {
            RegisterUserDto googleUser = googleAuthService.verifyGoogleToken(idToken);
            if (googleUser == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Google doğrulama başarısız.");
            }

            if (authService.existsByEmail(googleUser.email())) {
                return ResponseEntity.ok("Bu e-posta ile daha önce kayıt olunmuş.");
            }

            authService.register(googleUser.username(), googleUser.email(), "");

            return ResponseEntity.ok("Google ile kayıt başarılı!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Google ile kayıt sırasında hata oluştu.");
        }
    }

    @GetMapping("/users")
    public List<Entity> getAllUsers() {
        return authService.getAllUsers();
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody String emailString) {
        // Trim and remove any potential quotes
        String email = emailString.trim().replace("\"", "");

        if (email.isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        String result = authService.forgotPassword(email);

        if (result.equals("Reset link has been sent to your email.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }


    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestBody Map<String, String> payload
    ) {
        String email = payload.get("email");
        String token = payload.get("token");
        String newPassword = payload.get("newPassword");

        String result = authService.resetPassword(email, token, newPassword);
        return ResponseEntity.ok(result);
    }
}
