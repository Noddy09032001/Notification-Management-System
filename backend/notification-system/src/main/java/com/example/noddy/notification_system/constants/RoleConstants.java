package com.example.noddy.notification_system.constants;

public enum RoleConstants {
    ADMIN,  // access to the whole system
    SUPERADMIN,  // access to the whole system + template design
    SUPPORT,    // only access to dashboard and analytics and retry queues
    USER,   // access to create and send notifications
    VIEWER,    //only access to view dashboard and analytics
}
