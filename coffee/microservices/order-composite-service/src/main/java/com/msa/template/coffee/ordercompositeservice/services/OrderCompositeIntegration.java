package com.msa.template.coffee.ordercompositeservice.services;

import com.msa.template.coffee.api.core.order.rqrs.OrderCancelRq;
import com.msa.template.coffee.api.core.order.rqrs.OrderCancelRs;
import com.msa.template.coffee.api.core.order.rqrs.OrderListRs;
import com.msa.template.coffee.api.core.order.rqrs.OrderRq;
import com.msa.template.coffee.api.core.order.rqrs.OrderRs;
import com.msa.template.coffee.api.core.order.service.OrderService;
import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.product.ProductVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderCompositeIntegration implements OrderService {

	@Override
	public Mono<OrderRs> order(OrderRq rq) {
		return null;
	}

	@Override
	public Flux<OrderCancelRs> cancel(OrderCancelRq rq) {
		return null;
	}

	@Override
	public Mono<OrderListRs> getList(int memberId) {
		return null;
	}

}
