package com.project.gym.message.consumer;

import com.project.gym.message.event.TicketSaveEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaTicketConsumer {

    @KafkaListener(topics = "ticket-save-topic", groupId = "myGroup")
    public void consume(TicketSaveEvent event) throws IOException {
        log.info("ticketSave 이벤트 수신");
        log.info("[Id : {}, paymentId : {}] is deleted.", event.getId(), event.getPaymentId());
    }
}