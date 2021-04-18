package com.msa.template.coffee.payment.handler;

import com.msa.template.coffee.payment.controller.rqrs.RefundRs;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class RefundHandler {

    WebClient client = WebClient.create("http://localhost:8080");

    Mono<RefundRs> refundRsMono = client.get()
            .uri("/refund/{id}")
            .retrieve()
            .bodyToMono(RefundRs.class);

}
