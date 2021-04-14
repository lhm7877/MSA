package com.msa.template.coffee.ordercompositeservice.services;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderListDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.SuccessDto;
import com.msa.template.coffee.api.core.order.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderCompositeIntegration implements OrderService {

	@Override
	public Mono<SuccessDto> order(OrderDto rq) {
		return null;
	}

	@Override
	public Flux<SuccessDto> cancel(OrderCancelDto rq) {
		return null;
	}

	@Override
	public Mono<OrderListDto> getList(int memberId) {
		return null;
	}

}
