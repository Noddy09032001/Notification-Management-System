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
    private List<RolePermissionMappingResponse> associatedRolePermissions;

    public UserProfileResponse(){}

    public UserProfileResponse(String name, String username, String email, List<RolePermissionMappingResponse> associatedRolePermissions) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.associatedRolePermissions = associatedRolePermissions;
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

    public List<RolePermissionMappingResponse> getAssociatedRolePermissions() {
        return associatedRolePermissions;
    }

    public void setAssociatedRolePermissions(List<RolePermissionMappingResponse> associatedRolePermissions) {
        this.associatedRolePermissions = associatedRolePermissions;
    }
}
