package com.sargintek.furniture_draw_backend.authentication_service.controllers;

import com.sargintek.furniture_draw_backend.authentication_service.dtos.LoginUserDto;

import com.sargintek.furniture_draw_backend.authentication_service.dtos.RegisterUserDto;
import com.sargintek.furniture_draw_backend.authentication_service.entity.Entity;
import com.sargintek.furniture_draw_backend.authentication_service.services.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto loginUserDto) {

        return authService.login(loginUserDto.email(), loginUserDto.password());

    }

    @RequestMapping("/register")
    public String register(@RequestBody RegisterUserDto registerUserDto) {
        return authService.register(
                registerUserDto.username(),
                registerUserDto.email(),
                registerUserDto.password()
        );
    }


    @GetMapping("/users")
    public List<Entity> getAllUsers() {
        return authService.getAllUsers();
    }

}




