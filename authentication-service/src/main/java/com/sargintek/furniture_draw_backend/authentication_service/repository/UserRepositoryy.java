package com.sargintek.furniture_draw_backend.authentication_service.repository;

import com.sargintek.furniture_draw_backend.authentication_service.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepositoryy")
public interface UserRepositoryy extends JpaRepository<Entity, Long> {
    Optional<Entity> findByEmail(String email);
}
