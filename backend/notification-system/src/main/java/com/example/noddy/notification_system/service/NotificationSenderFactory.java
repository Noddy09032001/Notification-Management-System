package com.example.noddy.notification_system.service;

import com.example.noddy.notification_system.constants.NotificationChannel;
import com.example.noddy.notification_system.service.messageSenders.EmailSender;
import com.example.noddy.notification_system.service.messageSenders.InAppSender;
import com.example.noddy.notification_system.service.messageSenders.NotificationSender;
import com.example.noddy.notification_system.service.messageSenders.SmsSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderFactory {

    private final EmailSender emailSender;
    private final SmsSender smsSender;
    private final InAppSender inAppSender;

    public NotificationSenderFactory(EmailSender emailSender, SmsSender smsSender, InAppSender inAppSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.inAppSender = inAppSender;
    }

    public NotificationSender getNotificationSender(NotificationChannel channel){
        switch (channel) {
            case EMAIL:
                return emailSender;

            case SMS:
                return smsSender;

            case IN_APP:
                return inAppSender;

            default:
                return emailSender;
        }
    }
}
