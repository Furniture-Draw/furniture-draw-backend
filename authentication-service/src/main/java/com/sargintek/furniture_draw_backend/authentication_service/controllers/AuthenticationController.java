package com.sargintek.furniture_draw_backend.authentication_service.controllers;

import com.sargintek.furniture_draw_backend.authentication_service.dtos.LoginUserDto;
<<<<<<< HEAD
import com.sargintek.furniture_draw_backend.authentication_service.dtos.RegisterUserDto;
import com.sargintek.furniture_draw_backend.authentication_service.entity.Entity;
import com.sargintek.furniture_draw_backend.authentication_service.services.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

=======
import com.sargintek.furniture_draw_backend.authentication_service.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
>>>>>>> 946c2f699ce48a2078b29f19f51e702a9dbb372c
    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto loginUserDto) {
<<<<<<< HEAD
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
=======
        return authService.login(loginUserDto.username(), loginUserDto.password());
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
>>>>>>> 946c2f699ce48a2078b29f19f51e702a9dbb372c
