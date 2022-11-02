package com.enseirb.myapp.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CityListener {
    //private final Logger log = LoggerFactory.getLogger(CityListener.class);

    //@KafkaListener(id = "hq-city", topics = "cities")
    //public void received(String city){
    //    log.info("City received : {}", city);
    //}
}