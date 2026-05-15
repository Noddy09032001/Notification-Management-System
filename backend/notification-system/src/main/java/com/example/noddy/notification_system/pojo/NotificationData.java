package com.example.noddy.notification_system.pojo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notifications")
public class NotificationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // the primary key for the table

    @Column(nullable = false, unique = true)
    private String notificationId;  // the unique id for the message
    private LocalDateTime createdOn;  // storing the creation date for the message
    private LocalDateTime modifiedOn;   // storing the modified date for the message
    private String createdBy;  // storing the data for the message creater
    private String modifiedBy;  // storing the data for message modifier

    @Column(nullable = false, length = 100)
    private String eventType;  // type of the event or the message

    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageData> messages = new ArrayList<>();

    public NotificationData(){}

    public NotificationData(Long id, String notificationId, LocalDateTime createdOn, LocalDateTime modifiedOn, String modifiedBy, String createdBy, String eventType, List<MessageData> messages) {
        this.id = id;
        this.notificationId = notificationId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
        this.eventType = eventType;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<MessageData> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageData> messages) {
        this.messages = messages;
    }

    // Helper method
    public void addMessage(MessageData message) {
        messages.add(message);
        message.setNotification(this);
    }
}
