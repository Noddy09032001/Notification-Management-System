package com.example.noddy.notification_system.dto.request;

public class AuthUserRequest {

    private String userName;
    private String password;

    public AuthUserRequest(){}

    public AuthUserRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
