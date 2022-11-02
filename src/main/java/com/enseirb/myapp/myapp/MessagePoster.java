package com.enseirb.myapp.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessagePoster {
    //public static final String TOPIC = "log";
    private final Logger log = LoggerFactory.getLogger(CityLogger.class);

    
    @PostMapping
    public String post( @RequestBody String msg ){
        return msg;
    }
}
