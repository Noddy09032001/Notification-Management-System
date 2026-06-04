package com.example.noddy.notification_system.service;

import com.example.noddy.notification_system.constants.MessageStatus;
import com.example.noddy.notification_system.dto.request.CreateMessageDataRequest;
import com.example.noddy.notification_system.dto.request.CreateNotificationRequest;
import com.example.noddy.notification_system.pojo.MessageData;
import com.example.noddy.notification_system.pojo.NotificationData;
import com.example.noddy.notification_system.repository.MessageRepository;
import com.example.noddy.notification_system.repository.NotificationRepository;
import com.example.noddy.notification_system.service.messageSenders.NotificationSender;
import com.example.noddy.notification_system.utils.NotificationIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImplementation implements NotificationService{

    private MessageRepository messageRepository;
    private NotificationRepository notificationRepository;
    private NotificationIdGenerator idGenerator;
    private NotificationSenderFactory senderFactory;

    @Autowired
    public NotificationServiceImplementation(MessageRepository messageRepository, NotificationRepository notificationRepository,
                                             NotificationSenderFactory senderFactory, NotificationIdGenerator idGenerator){
        this.messageRepository = messageRepository;
        this.notificationRepository = notificationRepository;
        this.senderFactory = senderFactory;
        this.idGenerator = idGenerator;
    }

    @Override
    @Transactional
    public NotificationData createNotificationRequestData(CreateNotificationRequest requestBody) throws Exception{
        try {

            NotificationData data = new NotificationData();

            data.setNotificationId(idGenerator.generateNotificationId());
            data.setEventType(requestBody.getEventType());
            data.setCreatedBy(requestBody.getCreatedBy());

            data.setCreatedOn(LocalDateTime.now());
            data.setModifiedOn(LocalDateTime.now());

            for(CreateMessageDataRequest request : requestBody.getMessages()){
                MessageData message = new MessageData();
                message.setChannel(request.getChannel());
                message.setRecipient(request.getRecipient());
                message.setContent(request.getContent());

                message.setStatus(MessageStatus.CREATED);  // initially setting the status to created

                data.addMessage(message);  // adding the message to the notifications
            }

            // saving the notification data and the child messages data
            NotificationData savedNotificationData = notificationRepository.save(data);


            // sending of the messages to the different configured channels
            for(MessageData messageData : savedNotificationData.getMessages()){
                try {
                    NotificationSender sender = senderFactory.getNotificationSender(messageData.getChannel());   // getting the sender data
                    messageData.setStatus(MessageStatus.PROCESSING);   // setting the status to processing

                    sender.sendMessage(messageData);  // sending the message

                    // Updating message delivery details
                    messageData.setStatus(MessageStatus.SENT);  // setting the status to sent
                    messageData.setSentAt(LocalDateTime.now());  // updating the time of the message being sent
                } catch (Exception e) {

                    // Updating message failure details
                    messageData.setStatus(MessageStatus.FAILED);  // setting the status to failed
                    messageData.setProviderResponse(e.getMessage());
                }
            }

            return notificationRepository.save(savedNotificationData);  // saving the updated notifications data

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
