package com.example.noddy.notification_system.dto.response;

import com.example.noddy.notification_system.pojo.PermissionsData;
import com.example.noddy.notification_system.pojo.RoleData;

import java.util.List;
import java.util.Set;

// getting the response of the current user profile
public class UserProfileResponse {

    private String name;
    private String username;
    private String email;
    private Set<RoleData> roles;
    private Set<PermissionsData> permissions;

    public UserProfileResponse(){}

    public UserProfileResponse(String name, String username, String email, Set<RoleData> roles, Set<PermissionsData> permissions) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleData> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleData> roles) {
        this.roles = roles;
    }

    public Set<PermissionsData> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionsData> permissions) {
        this.permissions = permissions;
    }
}
