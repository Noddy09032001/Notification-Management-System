package com.example.noddy.notification_system.dto.request;

import com.example.noddy.notification_system.constants.RoleConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class CreateUserRequest {

    @NotBlank(message = "username is required")
    private String userName;

    @NotBlank(message = "Name is required")
    private String name;
    private String password;

    @NotBlank(message = "mobile number is needed")
    private String mobileNumber;

    @NotBlank(message = "At-least one Role is required")
    private Set<String> role;

    public CreateUserRequest(){}

    public CreateUserRequest(String userName, String name, String password, String mobileNumber, Set<String> role) {
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
