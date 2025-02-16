package com.kafka.playground.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    public NewTopic create(){
        return new NewTopic("my_topic_1", 5, (short)1);
    }
}
