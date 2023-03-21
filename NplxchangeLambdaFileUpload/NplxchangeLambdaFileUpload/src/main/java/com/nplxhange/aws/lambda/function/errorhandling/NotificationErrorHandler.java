package com.nplxhange.aws.lambda.function.errorhandling;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationErrorHandler {
    public void handler(SNSEvent event) {
        Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
        event.getRecords().forEach(record->logger.info("Dead Letter Queue Event"+record.toString()));
    }
}
