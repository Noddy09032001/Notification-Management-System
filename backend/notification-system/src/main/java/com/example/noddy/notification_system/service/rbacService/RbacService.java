package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.dto.request.*;
import com.example.noddy.notification_system.dto.response.AuthResponse;
import com.example.noddy.notification_system.dto.response.RolePermissionMappingResponse;

import java.util.List;

public interface RbacService {

    void createUser(CreateUserRequest request) throws Exception;
    AuthResponse login(AuthUserRequest request) throws Exception;

    void createRole(CreateRoleRequest request) throws Exception;
    void createPermissions(CreatePermissionRequest request) throws Exception;
    List<RolePermissionMappingResponse> createRolePermissionsMapping(List<RolePermissionMappingRequest> request) throws Exception;
}
