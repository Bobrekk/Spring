package com.beginner;

import com.beginner.model.Notification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class RabbitApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApp.class, args);
    }
}
