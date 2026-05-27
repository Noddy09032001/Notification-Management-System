package com.example.noddy.notification_system.controllers;

import com.example.noddy.notification_system.dto.request.CreateNotificationRequest;
import com.example.noddy.notification_system.pojo.NotificationData;
import com.example.noddy.notification_system.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class MessageController {

    private NotificationService notificationService;

    @Autowired
    public MessageController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SEND_NOTIFICATION')")
    public ResponseEntity<?> createMessageData(@Valid @RequestBody CreateNotificationRequest request) throws Exception {
        NotificationData data =  notificationService.createNotificationRequestData(request);
        return data != null ? ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Notification created successfully") : ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Notification could not be created");
    }
}
