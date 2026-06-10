package com.ems.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.client.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    // check duplicate email
    boolean existsByEmail(String email);

    // get client by business id
    Optional<Client> findByClientId(String clientId);
    
    boolean existsByClientId(String clientId);
    
    Optional<Client>findByEmail(String email);
    
}