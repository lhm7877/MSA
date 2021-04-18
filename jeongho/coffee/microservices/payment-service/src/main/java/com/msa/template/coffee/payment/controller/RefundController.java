package com.msa.template.coffee.payment.controller;

import com.msa.template.coffee.payment.controller.rqrs.RefundRs;
import com.msa.template.coffee.payment.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @GetMapping("/{id}")
    private Mono<RefundRs> getRefundList(@PathVariable String id){
        return refundService.getRefundList(id);
    }

    @GetMapping
    private Flux<RefundRs> getAllRefundList(){
        return refundService.getAllRefundList();
    }
}
