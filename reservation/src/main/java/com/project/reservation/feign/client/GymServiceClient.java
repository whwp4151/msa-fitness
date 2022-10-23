package com.project.reservation.feign.client;

import com.project.reservation.feign.dto.TicketRequest;
import com.project.reservation.feign.dto.TicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("GYM-SERVICE")
public interface GymServiceClient {

    @GetMapping("/gym-service/ticket/{ticketId}")
    TicketResponse getTicket(@PathVariable("ticketId") Long ticketId,
                             @RequestHeader(value="user-id") String userId);

    @PostMapping("/gym-service/count")
    void updateCount(@RequestBody TicketRequest ticketRequest,
                     @RequestHeader(value="user-id") String userId);

}
