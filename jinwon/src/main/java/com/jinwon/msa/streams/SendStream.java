package com.jinwon.msa.streams;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@AllArgsConstructor
@EnableBinding(Source.class)
public class SendStream {
    private final Source source;

    public void send(String name) {
        source.output().send(MessageBuilder.withPayload(name).build());
    }
}
