package com.sargintek.furniture_draw_backend.authentication_service.controllers;

import com.sargintek.furniture_draw_backend.authentication_service.dtos.LoginUserDto;
import com.sargintek.furniture_draw_backend.authentication_service.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto loginUserDto) {
        return authService.login(loginUserDto.username(), loginUserDto.password());
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
