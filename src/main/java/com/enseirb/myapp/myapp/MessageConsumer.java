package com.enseirb.myapp.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    private final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired MessageController messageController;

    @KafkaListener(id = "hq-chat", topics = "msg.json.hq")
    public Message received(Message msg, Acknowledgment ack){        
        log.info("message received : {}", msg);
        messageController.addToMessage(msg);
        ack.acknowledge();
        return msg;    
    }
}
