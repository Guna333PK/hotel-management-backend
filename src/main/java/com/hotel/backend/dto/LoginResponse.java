package com.hotel.backend.dto;

public class LoginResponse {

    private String message;
    private String role;
    private String email;

    public LoginResponse(String message, String role, String email) {
        this.message = message;
        this.role = role;
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}
