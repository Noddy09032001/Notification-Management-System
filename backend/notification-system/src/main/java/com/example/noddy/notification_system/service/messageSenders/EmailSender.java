package com.example.noddy.notification_system.service.messageSenders;

import com.example.noddy.notification_system.constants.MessageStatus;
import com.example.noddy.notification_system.pojo.MessageData;
import com.example.noddy.notification_system.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailSender implements NotificationSender{

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;
    private final MessageRepository messageRepository;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender, MessageRepository messageRepository) {
        this.javaMailSender = javaMailSender;
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendMessage(MessageData messageData) throws Exception {
        try {

            // Mark message as processing
            messageData.setStatus(MessageStatus.PROCESSING);

            // Create email payload
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom(username);   // setting the sender address for the email
            email.setTo(messageData.getRecipient()); // Recipient email
            email.setSubject("Notification Service Alert"); // Email subject
            System.out.println("The content message is: " + messageData.getContent());
            email.setText(messageData.getContent());  // Email body

            // Send email
            javaMailSender.send(email);

            // Update message metadata
            messageData.setStatus(MessageStatus.SENT);
            messageData.setSentAt(LocalDateTime.now());
            messageData.setProviderResponse("EMAIL_SENT_SUCCESSFULLY");

        } catch (Exception e) {
            // Update failure details
            messageData.setStatus(MessageStatus.FAILED);
            //messageData.setProviderResponse(e.getMessage());
            throw new Exception("Failed to send email: "+ e.getMessage());

        } finally {
            // Persist latest message state
            messageRepository.save(messageData);
        }
    }
}
