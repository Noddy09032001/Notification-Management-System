package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.dto.request.AuthUserRequest;
import com.example.noddy.notification_system.dto.request.CreateUserRequest;
import com.example.noddy.notification_system.dto.response.AuthResponse;

public interface RbacService {

    void createUser(CreateUserRequest request) throws Exception;
    AuthResponse login(AuthUserRequest request) throws Exception;
}
