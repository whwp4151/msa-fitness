package com.project.gym.config;

import com.project.gym.message.event.UserTypeUpdatedEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
//    private String kafka = "127.0.0.1:9092";
//
//    @Bean
//    public ProducerFactory<String, UserTypeUpdatedEvent> producerFactory(){
//        Map<String,Object> configs = new HashMap<>();
//        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory(configs);
//    }
//
//    @Bean
//    public KafkaTemplate<String, UserTypeUpdatedEvent> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}
