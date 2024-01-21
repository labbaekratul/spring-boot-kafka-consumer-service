package com.enduser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value) {
        try {
            logger.info("Received location update: {}", value);
            logger.info("Location update processed successfully: {}", value);
        } catch (Exception e) {
            logger.error("Error processing location update: {}", e.getMessage(), e);
        }
    }
}

