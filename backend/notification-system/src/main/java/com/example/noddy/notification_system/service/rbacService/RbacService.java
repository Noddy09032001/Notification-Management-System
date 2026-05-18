package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.dto.request.CreateUserRequest;

public interface RbacService {

    void createUser(CreateUserRequest request) throws Exception;
}
