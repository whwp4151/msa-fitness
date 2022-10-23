package com.project.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.user.domain.UserType;
import com.project.user.message.event.UserTypeUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class KafkaConsumerConfig {

    private final KafkaProperties kafkaProperties;
    private final ObjectMapper objectMapper;

//    private String kafka = "127.0.0.1:9092";
//
//    @Bean
//    public ConsumerFactory<String, UserTypeUpdatedEvent> userTypeConsumer() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
//
//        return new DefaultKafkaConsumerFactory<>(
//                configs,
//                new StringDeserializer(),
//                new JsonDeserializer<>(UserTypeUpdatedEvent.class));
//
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, UserTypeUpdatedEvent> userTypeListener() {
//        ConcurrentKafkaListenerContainerFactory<String, UserTypeUpdatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(userTypeConsumer());
//        return factory;
//    }



    @Bean
    public Map<String, Object> consumerConfiguration() {
        return new HashMap<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfiguration());
    }

//    @Bean
//    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setMessageConverter(new StringJsonMessageConverter());
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserTypeUpdatedEvent> userTypeListener() {
        ConcurrentKafkaListenerContainerFactory<String, UserTypeUpdatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
