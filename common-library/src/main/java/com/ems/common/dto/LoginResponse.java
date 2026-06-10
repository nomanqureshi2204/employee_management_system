package com.ems.common.dto;

public class LoginResponse {

    private String token;
    private String role;

    // No-args constructor
    public LoginResponse() {
    }

    // All-args constructor
    public LoginResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    // Getter for token
    public String getToken() {
        return token;
    }

    // Setter for token
    public void setToken(String token) {
        this.token = token;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }
}