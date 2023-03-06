package com.example.producer.send.controller;

import com.example.model.SendDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka")
public class SendController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @PostMapping("send")
    public void sendTemplate(@RequestBody SendDataModel dataModel){
        kafkaTemplate.send("sampleKafkaTopic", dataModel.data());
    }
}
