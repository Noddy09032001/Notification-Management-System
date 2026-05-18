package com.example.noddy.notification_system.pojo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @Column(name = "role_description")
    private String roleDescription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<PermissionsData> permissions = new HashSet<>();

    public void addPermission(PermissionsData permission) {
        this.permissions.add(permission);
    }

    public RoleData(){}

    public RoleData(Long id, String roleName, String roleDescription, Set<PermissionsData> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<PermissionsData> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionsData> permissions) {
        this.permissions = permissions;
    }
}
