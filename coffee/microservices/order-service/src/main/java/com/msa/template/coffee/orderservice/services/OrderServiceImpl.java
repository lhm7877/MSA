package com.msa.template.coffee.orderservice.services;

import com.msa.template.coffee.api.core.order.rqrs.OrderCancelRq;
import com.msa.template.coffee.api.core.order.rqrs.OrderCancelRs;
import com.msa.template.coffee.api.core.order.rqrs.OrderListRs;
import com.msa.template.coffee.api.core.order.rqrs.OrderRq;
import com.msa.template.coffee.api.core.order.rqrs.OrderRs;
import com.msa.template.coffee.api.core.order.service.OrderService;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class OrderServiceImpl implements OrderService {

	/**
	 * @Codes - E001 : 사용자 조회 불가
	 * - E002 : 메뉴 조회 불가
	 * - E003 : 결제 타입 조회 불가
	 * - E999 : 기타 에러 메세지 참조
	 */
    @Override
    public Mono<OrderRs> order(OrderRq rq) {
    	/*
         API member service
         checkMemberSn();
        */

        /*
         API goods service
         getGoodsList();
        */

        /*
         checkOrder();
        */

        /*
         saveOrder();
        */

        /*
         saveHistory();
        */

		OrderRs rs = new OrderRs();

		return Mono.just(rs);
    }

    @Override
    public Flux<OrderCancelRs> cancel(OrderCancelRq rq) {

        /*
         API member service
         checkMemberSn();
        */

        /*
         checkOrder()
        */

        /*
         cancelOrder()
        */

        /*
         saveOrderHistory()
        */

		OrderCancelRs rs = new OrderCancelRs();

		return Flux.just(rs);
    }

    @Override
    public Mono<OrderListRs> getList(int memberId) {
        return null;
    }

}
