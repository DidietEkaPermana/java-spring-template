package com.example.demo.service;

import com.example.demo.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    //to convert object from kafka
    @Bean
	public RecordMessageConverter converter() {
		return new JsonMessageConverter();
	}

    // @Autowired
    // private MessageDao messageDao;

    @Async("taskExecutor")
    @KafkaListener(topics = "poc", groupId = "poc_consumer")
    public void consumeMessageKafka(Message message)
    {
        // saveMessage(message);
        logger.info("received => " + message);
    }

    // @Async("taskExecutor")
    // @KafkaListener(id = "kafka-batch", topics = "${kafka.topic.app}")
    // public void receive(@Payload List<String> messages,
    //                     @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
    //                     @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

    //     for (int i = 0; i < messages.size(); i++) {
    //         LOGGER.info("Received message='{}' with partition-offset='{}'", messages.get(i),
    //                                 partitions.get(i) + "-" + offsets.get(i));
    //     }
    //     LOGGER.info("All batch messages received");
    // }

    // @Async("taskExecutor")
    // public void saveMessage(String kafkaMsg) throws JSONException {
    //     try {
    //         Message data = new Message();
    //         JSONObject messageJson = new JSONObject(kafkaMsg);
            // data.setMessageId(messageJson.getLong("sequenceNumber"));
            // data.setGenerateDate(messageJson.getLong("generatedTimestamp"));
            // messageDao.save(data);
            // logger.info("received => " + arg);

    //     } catch (Exception e){
    //         logger.error(kafkaMsg +"error: "+ e.getMessage());
    //     }
    // }
}