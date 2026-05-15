package com.example.noddy.notification_system.controllers;

import com.example.noddy.notification_system.dto.request.CreateNotificationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class MessageController {

    @PostMapping
    public ResponseEntity<?> createMessageData(@Valid @RequestBody CreateNotificationRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Notification created successfully");
    }
}
