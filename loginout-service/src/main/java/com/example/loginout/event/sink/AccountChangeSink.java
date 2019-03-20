package com.example.loginout.event.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface AccountChangeSink {

    @Input("accountChangeInput")
    SubscribableChannel input();
}
