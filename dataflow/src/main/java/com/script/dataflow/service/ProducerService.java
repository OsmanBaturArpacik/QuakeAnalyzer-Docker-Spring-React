package com.script.dataflow.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;


    public ProducerService(KafkaTemplate kafkaTemplate, @Value("${spring.kafka.producer.topic}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName, msg);
    }
}
