package com.example.demo.controller;

import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private ProducerService producer;

    @GetMapping("/producemessage/{n}") // produce message to kafka
    public ResponseEntity<String> produceMessageKafka(@PathVariable int n) {
        long result = 0;
        try {
            result = producer.produceMessage(n);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Message Published Successfully in " + result, HttpStatus.OK);
    }
}
