package com.project.trainer.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("GYM-SERVICE")
public interface GymServiceClient {
    @PostMapping("/gym-service/count")
    void updateCount( @RequestHeader(value="user-id") String userId);
}
