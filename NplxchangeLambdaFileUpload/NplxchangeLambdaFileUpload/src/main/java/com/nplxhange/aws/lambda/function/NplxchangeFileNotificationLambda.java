package com.nplxhange.aws.lambda.function;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NplxchangeFileNotificationLambda {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void handler(SNSEvent event) {
        event.getRecords().forEach(snsRecord -> {
                System.out.println(snsRecord);
        });
    }
}
