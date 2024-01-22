package com.cortadai.kafkatutorial.controller;

import com.cortadai.kafkatutorial.kafka.KafkaJsonProducer;
import com.cortadai.kafkatutorial.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private KafkaJsonProducer producer;

    public JsonMessageController(KafkaJsonProducer producer) {
        this.producer = producer;
    }

    // http://localhost:8080/api/v1/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        producer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to the topic");
    }

}
