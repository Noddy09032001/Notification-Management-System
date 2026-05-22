package com.example.noddy.notification_system.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NotificationIdGenerator {
    public NotificationIdGenerator(){}

    public String generateNotificationId() {
        String randomId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return "NOTIF-" + randomId;
    }
}
