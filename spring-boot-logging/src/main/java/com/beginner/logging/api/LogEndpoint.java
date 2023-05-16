package com.beginner.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    @GetMapping
    public String getDetails() {
        log.info("Get details metodu basladi.");
        return internalLogDetail();
    }

    public String internalLogDetail() {
        try {
            log.debug("internalLogDetail metodu basladi.");
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (InterruptedException e) {
            log.error("Hata: {}", e);
        }
        return "";
    }
}
