package com.project.user.message.consumer;

import com.project.user.domain.Users;
import com.project.user.message.event.UserTypeUpdatedEvent;
import com.project.user.repository.UserRepository;
import com.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

import java.io.IOException;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class UserEventConsumer {

    private Jackson2JsonObjectMapper mapper = new Jackson2JsonObjectMapper();
    private final UserService userService;

    @Bean
    public Consumer userTypeUpdated(){
        return (o) -> {
            log.info("userTypeUpdated 이벤트 수신");
            try {
                UserTypeUpdatedEvent event = mapper.fromJson(o, UserTypeUpdatedEvent.class);
                userService.getUser(event.getUserId());
                userService.updateUserType(event);
                log.info("[userId : {}, data : {}] is updated.", event.getUserId(), event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

}
