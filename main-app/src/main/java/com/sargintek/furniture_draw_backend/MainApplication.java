package com.sargintek.furniture_draw_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.sargintek.furniture_draw_backend.authentication_service",
                "com.sargintek.furniture_draw_backend.user_service"
        }

)

public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
