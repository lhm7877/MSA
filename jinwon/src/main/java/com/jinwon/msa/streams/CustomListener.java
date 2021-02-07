package com.jinwon.msa.streams;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class CustomListener {

    @StreamListener(value = Sink.INPUT)
    public void listener(String value) {
        log.debug("RECEIVED: " + value);
    }

}
