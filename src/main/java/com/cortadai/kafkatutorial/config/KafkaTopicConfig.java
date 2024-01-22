package com.cortadai.kafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic}")
    private String stringTopic;

    @Value("${kafka.json.topic}")
    private String jsonTopic;

    @Bean
    public NewTopic stringTopic(){
        return TopicBuilder.name(stringTopic).build();
    }

    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name(jsonTopic).build();
    }

}
