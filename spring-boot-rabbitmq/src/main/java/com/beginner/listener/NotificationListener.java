package com.beginner.listener;

import com.beginner.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "beginner-queue")
    public void handleMessage (Notification notification) {
        System.out.println("Message recieved..");
        System.out.println(notification.toString());
    }
}
