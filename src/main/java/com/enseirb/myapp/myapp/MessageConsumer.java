package com.enseirb.myapp.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    private final Logger log = LoggerFactory.getLogger(CityListener.class);

    @Autowired MessageController messageController;

    @KafkaListener(id = "hq-chat", topics = "cities")
    public String received(String msg){        
        log.info("message received : {}", msg);
        messageController.addToMessage(msg);        
        return msg;
    }
}