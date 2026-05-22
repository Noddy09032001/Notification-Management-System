package com.example.noddy.notification_system.dto.response;

import java.util.List;

public class AuthResponse {

    private String token;
    private String userName;
    private List<String> roles;
    private List<String> permissions;

    public AuthResponse(){}

    public AuthResponse(String token, String userName, List<String> roles, List<String> permissions) {
        this.token = token;
        this.userName = userName;
        this.roles = roles;
        this.permissions = permissions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
