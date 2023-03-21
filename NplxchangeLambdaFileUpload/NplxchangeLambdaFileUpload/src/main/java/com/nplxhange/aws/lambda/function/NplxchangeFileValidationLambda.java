package com.nplxhange.aws.lambda.function;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class NplxchangeFileValidationLambda {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private static final String NPLXCHANGE_NOTIFICATION_TOPIC = System.getenv("NPLXCHANGE_NOTIFICATION_TOPIC");
	private final AmazonSNS sns = AmazonSNSClientBuilder.defaultClient();

	public void handler(SNSEvent event) {
		event.getRecords().forEach(snsRecord -> {
			try {
				NplxchangeCheckoutEvent nplxchangeCheckoutEvent = objectMapper.readValue(snsRecord
						.getSNS().getMessage(),
						NplxchangeCheckoutEvent.class);
				System.out.println(nplxchangeCheckoutEvent);
				publishMessageToSNS("Validation has been Success");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		});
	}

	private void publishMessageToSNS(String nplxchangeCheckoutEvents) {
		sns.publish(NPLXCHANGE_NOTIFICATION_TOPIC, nplxchangeCheckoutEvents);
	}

}
