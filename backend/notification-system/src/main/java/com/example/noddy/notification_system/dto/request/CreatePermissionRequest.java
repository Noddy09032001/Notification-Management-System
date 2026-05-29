package com.example.noddy.notification_system.dto.request;

public class CreatePermissionRequest {

    private String permissionName;
    private String permissionDescription;
    private boolean isActive;

    public CreatePermissionRequest(){}

    public CreatePermissionRequest(String permissionName, String permissionDescription, boolean isActive) {
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
        this.isActive = isActive;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
