package com.sargintek.furniture_draw_backend.authentication_service.dtos;

public record LoginUserDto(String username, String password) {
    @Override
    public String toString() {
        return "LoginUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
