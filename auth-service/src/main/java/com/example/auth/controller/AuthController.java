package com.example.auth.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.auth.dto.AuthRequest;
import com.example.auth.dto.CreateUserRequest;
import com.example.auth.entity.UserEntity;
import com.example.auth.exception.AuthException;
import com.ems.common.util.JwtUtil;
import com.example.auth.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	// Login
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest req) {

		UserEntity user = repo.findByEmail(req.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

		// Account Locked check
		if (user.isAccountLocked()) {

			if (user.getLockTime().plusMinutes(5).isAfter(LocalDateTime.now())) {
				throw new RuntimeException("Account locked. Try after 5 minutes");
			}

			// unlock account after 5 minutes
			user.setAccountLocked(false);
			user.setFailedAttempts(0);
			user.setLockTime(null);
			repo.save(user);
		}

		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())

					);

			// Login success
			user.setFailedAttempts(0);
			repo.save(user);

			return jwtUtil.generateToken(user.getEmail(), user.getRole());

		} catch (BadCredentialsException e) {

			int attempts = user.getFailedAttempts() + 1;
			user.setFailedAttempts(attempts);

			if (attempts >= 5) {

				user.setAccountLocked(true);
				user.setLockTime(LocalDateTime.now());
				repo.save(user);

				throw new AuthException("Account locked for 5 minutes");
			}
			repo.save(user);
			
			throw new AuthException("Invalid email or password. Remaining attempts: "+(5-attempts));
		}

	}

	// internale API called by Employee Service and Client Service

	@PostMapping("/internal/create-user")
	public String createUser(@RequestBody CreateUserRequest request) {

		if (repo.findByEmail(request.getEmail()).isPresent()) {
			return "User already exists";
		}

		UserEntity user = new UserEntity();

		user.setName(request.getName());
		user.setEmail(request.getEmail());

		// Employee/client will set password later
		user.setPassword("");

		user.setRole(request.getRole());
		repo.save(user);

		return "User created successfully";
	}

}
