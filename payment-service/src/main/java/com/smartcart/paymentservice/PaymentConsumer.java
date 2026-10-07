package com.smartcart.paymentservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    private final KafkaTemplate<String, String> kafka;

    public PaymentConsumer(KafkaTemplate<String, String> kafka) {
        this.kafka = kafka;
    }

    @KafkaListener(topics = "order-created", groupId = "payment-service")
    public void process(String event) {
        System.out.println("Payment processed: " + event);
        kafka.send("payment-completed", event);
    }
}
