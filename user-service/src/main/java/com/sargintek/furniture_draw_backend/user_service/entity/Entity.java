package com.sargintek.furniture_draw_backend.user_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@jakarta.persistence.Entity
@Table(name = "employe")
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "reset_token_expiration")
    private LocalDateTime resetTokenExpiration;

    @Column(name = "reset_token_used")
    private boolean resetTokenUsed = false;

    public Entity() {}

    public Entity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getResetToken() {
        return this.resetToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isResetTokenUsed() {
        return resetTokenUsed;
    }

    public void setResetTokenExpiration(LocalDateTime expiration) {
        this.resetTokenExpiration = expiration;
    }

    public LocalDateTime getResetTokenExpiration() {
        return this.resetTokenExpiration;
    }
    public void setResetTokenUsed(boolean resetTokenUsed) {
        this.resetTokenUsed = resetTokenUsed;
    }
}
