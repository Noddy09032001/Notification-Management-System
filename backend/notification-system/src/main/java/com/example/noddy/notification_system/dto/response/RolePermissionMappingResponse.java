package com.example.noddy.notification_system.dto.response;

import java.util.List;

public class RolePermissionMappingResponse {

    private String role;
    private List<String> permissions;

    public RolePermissionMappingResponse(){}

    public RolePermissionMappingResponse(String role, List<String> permissions) {
        this.role = role;
        this.permissions = permissions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
