package com.example.noddy.notification_system.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class PermissionsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_name", nullable = false, unique = true)
    private String permissionName;

    @Column(name = "permission_description")
    private String permissionDescription;

    public PermissionsData(){}

    public PermissionsData(Long id, String permissionName, String permissionDescription) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
