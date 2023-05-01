package com.application.HPDM.Login;

public class LoginResponse {
    private String role;
    private String id;

    public LoginResponse(String role, String id) {
        this.role = role;
        this.id = id;
    }

    public LoginResponse() {
    }
    public String getRole() {
        return role;
    }
    public String getId() {
        return id;
    }
}
