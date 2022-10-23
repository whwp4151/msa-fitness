package com.project.payment.message.consumer;

import com.project.payment.message.event.PaymentRollbackEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "payment-rollback-topic", groupId = "myGroup")
    public void consume(PaymentRollbackEvent event) throws IOException {
        System.out.println("((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))");
        log.info("userTypeUpdated 이벤트 수신");
        log.info("[userId : {}, data : {}] is updated.", event.getOrderId(), event.getPaymentId(), event);

    }
}