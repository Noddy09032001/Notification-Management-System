package com.example.noddy.notification_system.service.messageSenders;

import com.example.noddy.notification_system.pojo.MessageData;

public interface NotificationSender {
    void sendMessage(MessageData messageData) throws Exception;
}
