package com.example.noddy.notification_system.repository;

import com.example.noddy.notification_system.constants.MessageStatus;
import com.example.noddy.notification_system.constants.NotificationChannel;
import com.example.noddy.notification_system.pojo.MessageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageData, Long> {

    // Find all messages by status
    List<MessageData> findByStatus(MessageStatus status);

    // Find all messages by notification channel
    List<MessageData> findByChannel(NotificationChannel channel);

    // Find all messages for a notification
    @Query("SELECT m FROM MessageData m WHERE m.notification.id = :notificationId")
    List<MessageData> findByNotificationId(@Param("notificationId") Long notificationId);

    /**
     * Find all messages for a recipient
     */
    List<MessageData> findByRecipient(String recipient);

    /**
     * Find messages by recipient and channel
     */
    List<MessageData> findByRecipientAndChannel(String recipient, NotificationChannel channel);

    /**
     * Find messages by status and channel
     */
    List<MessageData> findByStatusAndChannel(MessageStatus status, NotificationChannel channel);

    /**
     * Find failed messages eligible for retry
     */
    @Query("SELECT m FROM MessageData m WHERE m.status = 'FAILED' AND m.retryCount < :maxRetryCount")
    List<MessageData> findFailedMessagesForRetry(@Param("maxRetryCount") Integer maxRetryCount);
}
