package com.enseirb.myapp.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CityLogger {
    public static final String TOPIC = "log";
    private final Logger log = LoggerFactory.getLogger(CityLogger.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationStarted() {
        log.info("Application started");
        kafkaTemplate.send(TOPIC, "hamza and quatadah application" + Instant.now());
    }

}
