package com.msa.template.coffee.api.core.order.service;

import com.msa.template.coffee.api.core.order.rqrs.OrderCancelRq;
import com.msa.template.coffee.api.core.order.rqrs.OrderCancelRs;
import com.msa.template.coffee.api.core.order.rqrs.OrderListRs;
import com.msa.template.coffee.api.core.order.rqrs.OrderRq;
import com.msa.template.coffee.api.core.order.rqrs.OrderRs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
	@PostMapping(
		value    = "/order",
		produces = "application/json")
	Mono<OrderRs> order(OrderRq rq);

	@GetMapping(
		value    = "/order/cancel",
		produces = "application/json")
	Flux<OrderCancelRs> cancel(OrderCancelRq rq);

	@GetMapping(
			value    = "/order/list/{memberId}",
			produces = "application/json")
	Mono<OrderListRs> getList(@PathVariable int memberId);
}
