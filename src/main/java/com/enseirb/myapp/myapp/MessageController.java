package com.enseirb.myapp.myapp;

import java.util.ArrayList;

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
    private final Logger log = LoggerFactory.getLogger(CityLogger.class);
    private ArrayList<String> messages = new ArrayList<String>();

    @Autowired
    MessageProducer messageProducer;

    @PostMapping
    public String post(@RequestBody String msg ){     
        System.out.println("controller : " + msg);
        messageProducer.send(msg);        
        return msg;
    }

    @GetMapping
    public String get(){    
        String tenMessages = "";
        for (int i =  messages.size() - 1; i >= Math.max(messages.size() - 9, 0); i--){
            tenMessages += messages.get(i) + "\n";            
        }
        return tenMessages;
    }   

    public void addToMessage(String msg){
        System.out.println("call here");      
        System.out.println(messages.toString());  
        messages.add(msg);
        System.out.println(messages.toString());
    }
}
