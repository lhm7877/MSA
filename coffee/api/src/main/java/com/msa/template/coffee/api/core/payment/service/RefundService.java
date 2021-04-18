package com.msa.template.coffee.api.core.payment.service;

import com.msa.template.coffee.api.core.payment.dto.Refund;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface RefundService {
    @PostMapping(
            value = "/refund",
            produces = "application/json")
    Boolean refund(@PathVariable Refund refund);
}
