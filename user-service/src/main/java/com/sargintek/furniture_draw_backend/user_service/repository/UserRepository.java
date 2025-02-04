package com.sargintek.furniture_draw_backend.user_service.repository;

import com.sargintek.furniture_draw_backend.user_service.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Entity, Long> {
    Optional<Entity> findByEmail(String email);
    boolean existsByEmail(String email);
}
