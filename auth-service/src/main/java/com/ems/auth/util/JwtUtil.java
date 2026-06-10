package com.ems.auth.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // SECRET KEY
    private final SecretKey key =
            Keys.hmacShaKeyFor(
                    "mysecretkeymysecretkeymysecretkey12".getBytes()
            );

    // TOKEN VALIDITY = 1 HOUR
    private final long EXPIRATION = 1000 * 60 * 60;

    // GENERATE TOKEN
    public String generateToken(String email, String role) {

        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + EXPIRATION)
                )
                .signWith(key)
                .compact();
    }

    // EXTRACT ALL CLAIMS
    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // EXTRACT EMAIL
    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    // EXTRACT ROLE
    public String extractRole(String token) {
        return extractClaims(token)
                .get("role", String.class);
    }

    // VALIDATE TOKEN
    public boolean validateToken(String token) {

        try {

            Claims claims = extractClaims(token);

            return claims.getExpiration()
                    .after(new Date());

        } catch (Exception e) {

            return false;
        }
    }
}