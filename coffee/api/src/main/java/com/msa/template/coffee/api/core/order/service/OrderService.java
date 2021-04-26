package com.msa.template.coffee.api.core.order.service;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.SuccessDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
	@PostMapping(
		value    = "/order",
		produces = "application/json")
	Mono<SuccessDto> order(OrderDto rq);

	@GetMapping(
		value    = "/order/cancel",
		produces = "application/json")
	Flux<SuccessDto> cancel(OrderCancelDto rq);

	@GetMapping(
			value    = "/order/list/{memberId}",
			produces = "application/json")
	Flux<OrderLoadDto> getList(@PathVariable int memberId);
}
