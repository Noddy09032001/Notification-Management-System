package com.example.noddy.notification_system.pojo;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserData implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;   // the username for the given user
    private String name;   // the complete name for the user

    @Column(nullable = false)
    private String password;   // password for the user, stored in encrypted format
    private String mobileNumber;

    private LocalDateTime createdOn;  // storing the creation date for the message
    private LocalDateTime modifiedOn;   // storing the modified date for the message

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleData> roles = new HashSet<>();

    public void addRole(RoleData role) {
        this.roles.add(role);
    }

    public UserData(Long id, String userName, String name, String password, String mobileNumber, LocalDateTime createdOn, LocalDateTime modifiedOn, Set<RoleData> roles) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.roles = roles;
    }

    public UserData(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Set<RoleData> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleData> roles) {
        this.roles = roles;
    }
}
