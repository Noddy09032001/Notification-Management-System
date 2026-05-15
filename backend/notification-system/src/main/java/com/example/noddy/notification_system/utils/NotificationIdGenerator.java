package com.example.noddy.notification_system.utils;

import java.util.UUID;

public class NotificationIdGenerator {
    public NotificationIdGenerator(){}

    public String generateNotificationId() {
        String randomId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return "NOTIF-" + randomId;
    }
}
