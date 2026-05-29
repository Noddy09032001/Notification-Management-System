package com.example.noddy.notification_system.dto.request;

import com.example.noddy.notification_system.constants.RoleConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRoleRequest {

    @NotBlank(message = "Role is required")
    private String roleName;
    private String roleDescription;
    private boolean isActive;

    public CreateRoleRequest(){}

    public CreateRoleRequest(String roleName, String roleDescription, boolean isActive) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.isActive = isActive;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
