package com.enseirb.myapp.myapp;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class MessageProducer {    
    public static final String TOPIC = "msg.json";
    private final Logger log = LoggerFactory.getLogger(CityLogger.class);

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;
    
    public Message send(Message msg){
        System.out.println("producer : " + msg);
        kafkaTemplate.send(TOPIC, msg);
        return msg;
    }

}
