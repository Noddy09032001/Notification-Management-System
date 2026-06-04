package com.example.noddy.notification_system.service;

import com.example.noddy.notification_system.dto.request.CreateNotificationRequest;
import com.example.noddy.notification_system.pojo.NotificationData;

public interface NotificationService {

    NotificationData createNotificationRequestData(CreateNotificationRequest requestBody) throws Exception;
}
