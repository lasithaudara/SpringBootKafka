package com.example.springbootkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringbootkafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootkafkaApplication.class, args);
	}
	@Bean
	public String sendMsg(KafkaTemplate<String, String> kafkaTemplate){
		kafkaTemplate.send("sampleKafkaTopic", "hello kafka");
		return "test";
	}

}
