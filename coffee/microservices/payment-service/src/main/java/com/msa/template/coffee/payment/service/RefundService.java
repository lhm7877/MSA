package com.msa.template.coffee.payment.service;

import com.msa.template.coffee.payment.controller.rqrs.RefundRs;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RefundService {
    public Mono<RefundRs> getRefundList(@PathVariable String id) {

        return null;
    }

    public Flux<RefundRs> getAllRefundList(){
        return null;
    }
}
