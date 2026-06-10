package com.example.auth.dto;



public class AuthRequest {

    private String email;
    private String password;

    // Default constructor
    public AuthRequest() {
    }

    // Parameterized constructor (optional but useful)
    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}