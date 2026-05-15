package com.example.noddy.notification_system.constants;

public enum MessageStatus {
    CREATED,  // Notification created but not yet processed
    QUEUED, // Notification added to the queue
    SCHEDULED,  // Notification scheduled for future delivery
    PROCESSING,  // Notification currently being processed
    SENT,  // Notification sent to external provider
    DELIVERED,  // Notification successfully delivered to user
    READ, // Notification opened/read by user
    FAILED, // Notification delivery failed
    RETRYING,  // Notification retry is in progress
    RETRY_EXHAUSTED,  // Maximum retry attempts exhausted
    CANCELLED,  // Notification cancelled before delivery
    EXPIRED // Notification expired before delivery
}
