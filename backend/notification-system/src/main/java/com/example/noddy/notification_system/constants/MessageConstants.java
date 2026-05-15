package com.example.noddy.notification_system.constants;

public class MessageConstants {

    private static final Integer MAX_RETRIES_ALLOWED = 3;  // the maximum retries allowed for the messages to be sent

    public MessageConstants(){}

    public static Integer getMaxRetriesAllowed() {
        return MAX_RETRIES_ALLOWED;
    }
}
