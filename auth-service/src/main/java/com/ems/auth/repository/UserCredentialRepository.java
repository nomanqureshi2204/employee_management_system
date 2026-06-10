package com.ems.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.auth.entity.UserCredential;

public interface UserCredentialRepository
        extends JpaRepository<UserCredential, Long> {

    Optional<UserCredential> findByEmail(String email);
}