package com.example.noddy.notification_system.service.messageSenders;

import com.example.noddy.notification_system.pojo.MessageData;
import org.springframework.stereotype.Service;

@Service
public class SmsSender implements NotificationSender{

    @Override
    public void sendMessage(MessageData messageData) throws Exception {
        try {

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
