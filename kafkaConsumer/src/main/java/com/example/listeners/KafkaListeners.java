package com.example.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "sampleKafkaTopic", groupId = "sample")
    void listener(String data){
        System.out.println("Date Received - " + data);
    }
}
