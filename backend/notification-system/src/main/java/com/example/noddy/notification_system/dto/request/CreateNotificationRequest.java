package com.example.noddy.notification_system.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateNotificationRequest {

    // Type of business event
    @NotBlank(message = "Event type is required")
    private String eventType;

    // User/system creating the notification
    @NotBlank(message = "Created by is required")
    private String createdBy;

    // List of channel-specific messages
    @Valid
    @NotEmpty(message = "At least one message is required")
    private List<CreateMessageDataRequest> messages;

    public CreateNotificationRequest(){}

    public CreateNotificationRequest(String eventType, String createdBy, List<CreateMessageDataRequest> messages){
        this.eventType = eventType;
        this.createdBy = createdBy;
        this.messages = messages;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<CreateMessageDataRequest> getMessages() {
        return messages;
    }

    public void setMessages(List<CreateMessageDataRequest> messages) {
        this.messages = messages;
    }
}
