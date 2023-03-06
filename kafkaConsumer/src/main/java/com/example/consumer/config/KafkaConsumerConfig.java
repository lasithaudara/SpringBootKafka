package com.example.consumer.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-server}")
    private String boostrapServer;

    public Map<String, Object> consumerConfig(){
        Map<String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, boostrapServer);
        config.put(KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return config;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    public KafkaListenerContainerFactory
            <ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory(
                    ConsumerFactory<String, String> consumerFactory){
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                                            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
