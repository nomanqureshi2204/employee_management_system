package com.example.auth.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}