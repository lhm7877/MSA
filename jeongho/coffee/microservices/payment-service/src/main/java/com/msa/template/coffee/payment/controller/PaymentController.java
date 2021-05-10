package com.msa.template.coffee.payment.controller;

import com.msa.template.coffee.payment.controller.rqrs.PaymentRq;
import com.msa.template.coffee.payment.controller.rqrs.PaymentRs;
import com.msa.template.coffee.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public PaymentRs payment(PaymentRq rq){
        PaymentRs rs = new PaymentRs();

        paymentService.payment(rq);

        return rs;
    }
}
