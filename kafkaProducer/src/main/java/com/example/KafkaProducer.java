package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class KafkaProducer {    public static void main(String[] args) {
        SpringApplication.run(KafkaProducer.class, args);
    }
    @Bean
    public String sendKeys(KafkaTemplate<String, String> kafkaTemplate){

        IntStream.range(0, 100).forEach(index->{
            kafkaTemplate.send("sampleKafkaTopic", "Welcome to Kafka - " + index);
        });


    return "test";
    }
}
