package com.example.noddy.notification_system.repository;

import com.example.noddy.notification_system.pojo.NotificationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationData, Long> {

    // Find notification using external message id
    //Optional<NotificationData> findByMessageId(String messageId);
}
