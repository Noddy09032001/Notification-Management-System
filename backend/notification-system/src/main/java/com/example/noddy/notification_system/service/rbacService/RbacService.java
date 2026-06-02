package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.dto.request.*;
import com.example.noddy.notification_system.dto.response.AuthResponse;
import com.example.noddy.notification_system.dto.response.RolePermissionMappingResponse;
import com.example.noddy.notification_system.dto.response.UserProfileResponse;
import com.example.noddy.notification_system.pojo.PermissionsData;
import com.example.noddy.notification_system.pojo.RoleData;

import java.util.List;

public interface RbacService {

    void createUser(CreateUserRequest request) throws Exception;
    AuthResponse login(AuthUserRequest request) throws Exception;

    void createRole(CreateRoleRequest request) throws Exception;
    void createPermissions(CreatePermissionRequest request) throws Exception;
    List<RolePermissionMappingResponse> createRolePermissionsMapping(List<RolePermissionMappingRequest> request) throws Exception;

    List<RoleData> getAllRoles() throws Exception;
    List<PermissionsData> getAllPermissions() throws Exception;
    UserProfileResponse getUserProfileDetails(String username) throws Exception;
}
