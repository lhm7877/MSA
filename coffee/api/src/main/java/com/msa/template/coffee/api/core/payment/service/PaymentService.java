package com.msa.template.coffee.api.core.payment.service;

import com.msa.template.coffee.api.core.payment.dto.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface PaymentService {
    @PostMapping(
            value = "/payment",
            produces = "application/json")
    Boolean pay(@PathVariable Payment payment);
}
