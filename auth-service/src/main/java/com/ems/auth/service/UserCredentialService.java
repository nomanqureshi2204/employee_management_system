package com.ems.auth.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.ems.auth.entity.UserCredential;
import com.ems.auth.repository.UserCredentialRepository;
import com.ems.auth.util.JwtUtil;
import com.ems.common.dto.LoginRequest;
import com.ems.common.dto.LoginResponse;

@Service
public class UserCredentialService {

    @Autowired
    private UserCredentialRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest request) {

        // FIND USER
        UserCredential user =
                repository.findByEmail(request.getEmail())
                        .orElse(null);

        // USER NOT FOUND
        if (user == null) {

            return new LoginResponse(
                    "USER_NOT_FOUND",
                    "NO_ROLE");
        }

        // ACCOUNT DISABLED
        if (!user.isEnabled()) {

            return new LoginResponse(
                    "ACCOUNT_DISABLED",
                    "NO_ROLE");
        }

        // ACCOUNT LOCK CHECK
        if (user.isAccountLocked()) {

            LocalDateTime lockTime =
                    user.getLockTime();

            long minutes =
                    ChronoUnit.MINUTES.between(
                            lockTime,
                            LocalDateTime.now());

            // UNLOCK AFTER 5 MINUTES
            if (minutes >= 5) {

                user.setAccountLocked(false);

                user.setFailedAttempt(0);

                user.setLockTime(null);

                repository.save(user);

            } else {

                return new LoginResponse(
                        "ACCOUNT_LOCKED_TRY_AFTER_5_MINUTES",
                        "NO_ROLE");
            }
        }

        // AUTHENTICATE USER
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

        } catch (BadCredentialsException e) {

            // INCREASE FAILED ATTEMPTS
            int attempts =
                    user.getFailedAttempt();

            attempts++;

            user.setFailedAttempt(attempts);

            // LOCK ACCOUNT AFTER 5 ATTEMPTS
            if (attempts >= 5) {

                user.setAccountLocked(true);

                user.setLockTime(
                        LocalDateTime.now());

                repository.save(user);

                return new LoginResponse(
                        "ACCOUNT_LOCKED_TRY_AFTER_5_MINUTES",
                        "NO_ROLE");
            }

            repository.save(user);

            return new LoginResponse(
                    "INVALID_PASSWORD",
                    "NO_ROLE");
        }

        // RESET FAILED ATTEMPTS
        user.setFailedAttempt(0);

        repository.save(user);

        // GENERATE JWT TOKEN
        String token =
                jwtUtil.generateToken(
                        user.getEmail(),
                        user.getRole().name());

        System.out.println(
                "LOGIN SUCCESS : "
                        + user.getEmail());

        // RETURN RESPONSE
        return new LoginResponse(
                token,
                user.getRole().name());
    }
}