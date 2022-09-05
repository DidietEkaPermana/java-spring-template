package com.example.demo.service;

import com.example.demo.entity.Message;

// import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private static final String TOPIC = "poc";

    @Autowired
    private KafkaTemplate<Object,Message> kafkaTemplate;

    public long produceMessage(int n){
        long  start = System.currentTimeMillis();
        logger.info("start message => " +  System.currentTimeMillis());

        for(int i=1; i<=n; i++){
            generateMessage(i);
        }
        long finish = System.currentTimeMillis()-start;

        logger.info("end message => " +  System.currentTimeMillis());
        return finish;
    }

    @Async("taskExecutor")
    public void generateMessage(int i){
        try {
            // JSONObject message = new JSONObject();
            // long millis = System.currentTimeMillis();
            // message.put("sequenceNumber", i);
            // message.put("generatedTimestamp", millis);
            // this.kafkaTemplate.send(TOPIC, message.toString());
            Message message = new Message(Long.valueOf(i), System.currentTimeMillis());
            this.kafkaTemplate.send(TOPIC, message);
        } catch (Exception e){
            logger.error(i + "error: " + e.getMessage());
        }
    }
}