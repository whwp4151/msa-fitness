package com.project.user.message.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomChannels {
    String INPUT = "inboundOrgChanges";

    @Input
    SubscribableChannel inboundOrgChanges();
//    @Input("inboundOrgChanges")
//    SubscribableChannel orgs();
}
