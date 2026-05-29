package com.example.noddy.notification_system.controllers;

import com.example.noddy.notification_system.dto.request.*;
import com.example.noddy.notification_system.dto.response.AuthResponse;
import com.example.noddy.notification_system.dto.response.RolePermissionMappingResponse;
import com.example.noddy.notification_system.service.rbacService.RbacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class RbacSettingsController {

    private RbacService rbacService;

    @Autowired
    public RbacSettingsController(RbacService rbacService){
        this.rbacService = rbacService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody AuthUserRequest request) throws Exception {
        AuthResponse response = rbacService.login(request);    // calling the login method for the same
        return ResponseEntity.ok(response);   // storing the response from the same
    }

    @PostMapping("/register")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody CreateUserRequest request) throws Exception {
        rbacService.createUser(request);    // calling the login method for the same
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PostMapping("/roles")
    public ResponseEntity<?> createRole(@Valid @RequestBody CreateRoleRequest request) throws Exception{
        rbacService.createRole(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Roles created successfully");
    }

    @PostMapping("/permissions")
    public ResponseEntity<?> createPermissions(@Valid @RequestBody CreatePermissionRequest request) throws Exception{
        rbacService.createPermissions(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Permissions created successfully");
    }

    @PostMapping("/role-permissions")
    public ResponseEntity<?> createRolePermissionMappings(@Valid @RequestBody List<RolePermissionMappingRequest> request) throws Exception{
        List<RolePermissionMappingResponse> response = rbacService.createRolePermissionsMapping(request);
        return ResponseEntity.ok(response);
    }
}
