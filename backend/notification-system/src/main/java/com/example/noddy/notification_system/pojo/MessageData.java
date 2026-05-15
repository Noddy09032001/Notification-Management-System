package com.example.noddy.notification_system.pojo;

import com.example.noddy.notification_system.constants.MessageStatus;
import com.example.noddy.notification_system.constants.NotificationChannel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_messages")
public class MessageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // the id of the message

    @Enumerated(EnumType.STRING)
    private NotificationChannel channel;   // the channel via which the message was sent


    private String recipient; // Recipient address

    @Column(columnDefinition = "TEXT")
    private String content;  // the content of the message

    @Enumerated(EnumType.STRING)
    private MessageStatus status;  // the current status of the message
    private Integer retryCount;  // the number of times the retries happened
    private String providerResponse;
    private LocalDateTime sentAt;  // time at which the message was sent

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id")
    private NotificationData notification;

    public MessageData(){}

    public MessageData(Long id, NotificationChannel channel, String recipient, String content, MessageStatus status, Integer retryCount, String providerResponse, LocalDateTime sentAt, NotificationData notification) {
        this.id = id;
        this.channel = channel;
        this.recipient = recipient;
        this.content = content;
        this.status = status;
        this.retryCount = retryCount;
        this.providerResponse = providerResponse;
        this.sentAt = sentAt;
        this.notification = notification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getProviderResponse() {
        return providerResponse;
    }

    public void setProviderResponse(String providerResponse) {
        this.providerResponse = providerResponse;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public NotificationData getNotification() {
        return notification;
    }

    public void setNotification(NotificationData notification) {
        this.notification = notification;
    }
}
