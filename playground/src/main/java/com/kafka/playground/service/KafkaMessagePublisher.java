package com.kafka.playground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void publishToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> response = template.send("demo_topic", message);
        response.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message : " + message + "with offset" + result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to send message caused by : " + ex.getMessage());
            }
        });
    }


}
