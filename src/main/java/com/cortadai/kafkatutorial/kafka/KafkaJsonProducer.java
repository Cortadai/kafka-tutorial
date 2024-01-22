package com.cortadai.kafkatutorial.kafka;

import com.cortadai.kafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    @Value("${kafka.json.topic}")
    private String jsonTopic;

    private KafkaTemplate<String, String> template;

    public KafkaJsonProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("Json message sent %s", user.toString()));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, jsonTopic)
                .build();
        template.send(message);
    }


}
