package com.beginner.aop.api;

import com.beginner.aop.service.MessageService;
import com.beginner.aop.service.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;
    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody String message) {
        secondMessageService.mesaj(message);
        return ResponseEntity.ok(messageService.mesajVer(message));
    }
}
