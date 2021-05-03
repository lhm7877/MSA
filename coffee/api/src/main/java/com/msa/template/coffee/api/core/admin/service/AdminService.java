package com.msa.template.coffee.api.core.admin.service;

import com.msa.template.coffee.api.core.admin.dto.SalesDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;

public interface AdminService {
    @PostMapping(
            value    = "/admin/sales",
            produces = "application/json")
    Flux<SalesDto> getSales(SalesDto rq);

    @PostMapping(
            value    = "/admin/sales/{salesId}}",
            produces = "application/json")
    Flux<SalesDto> getSalesDetails(@PathVariable Long salesId);
}
