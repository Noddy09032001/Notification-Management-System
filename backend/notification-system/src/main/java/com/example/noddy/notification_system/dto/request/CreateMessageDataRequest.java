package com.example.noddy.notification_system.dto.request;

import com.example.noddy.notification_system.constants.NotificationChannel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMessageDataRequest {

    // Delivery channel
    @NotNull(message = "Channel is required")
    private NotificationChannel channel;

    @NotBlank(message = "Recipient is required")
    @Email(message = "Invalid email format")
    private String recipient;

    // Channel-specific content
    @NotBlank(message = "Content is required")
    private String content;

    public CreateMessageDataRequest(){}

    public CreateMessageDataRequest(NotificationChannel channel, String content){
        this.channel = channel;
        this.content = content;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
