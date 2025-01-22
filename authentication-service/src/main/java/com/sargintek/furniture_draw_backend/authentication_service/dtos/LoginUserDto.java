package com.sargintek.furniture_draw_backend.authentication_service.dtos;

<<<<<<< HEAD
public record LoginUserDto(String email, String password) {
//    @Override
//    public String toString() {
//        return "LoginUserDto{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
=======
public record LoginUserDto(String username, String password) {
    @Override
    public String toString() {
        return "LoginUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
>>>>>>> 946c2f699ce48a2078b29f19f51e702a9dbb372c
}
