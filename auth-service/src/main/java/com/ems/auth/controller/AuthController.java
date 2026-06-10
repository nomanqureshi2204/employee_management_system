package com.ems.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.auth.service.UserCredentialService;
import com.ems.common.dto.LoginRequest;
import com.ems.common.dto.LoginResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserCredentialService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return service.login(request);
    }

    @GetMapping("/test")
    public String test() {

        return "Protected API Accessed Successfully";
    }

    @GetMapping("/encode")
    public String encode() {

        return passwordEncoder.encode("1234");
    }
}