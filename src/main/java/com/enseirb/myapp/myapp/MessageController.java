package com.enseirb.myapp.myapp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
    //public static final String TOPIC = "log";
    private final Logger log = LoggerFactory.getLogger(MessageController.class);
    private List<Message> messages = new ArrayList<Message>();

    @Autowired
    MessageProducer messageProducer;

    @PostMapping
    public Message post(@RequestBody Message msg ){
        System.out.println("controller : " + msg);
        messageProducer.send(msg);        
        return msg;
    }

    @GetMapping
    public List<Message> get(){
        List<Message> toShow = new ArrayList<Message>();
                
        synchronized (this) {
            for (int i = messages.size() - 1; i >= Math.max(messages.size() - 10, 0); i--) {
                toShow.add(messages.get(i));
            }
        }
        return toShow;
    }   

    public void addToMessage(Message msg){
        synchronized (this) {
            messages.add(msg);
        }
    }
}
