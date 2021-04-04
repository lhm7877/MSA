package com.msa.template.coffee.order.handler;

import com.msa.template.coffee.order.handler.rqrs.OrderCancelRq;
import com.msa.template.coffee.order.handler.rqrs.OrderCancelRs;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderCancelHandler {

    public Mono<ServerResponse> cancel(OrderCancelRq rq) {

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

        return ServerResponse.ok().body(rs, OrderCancelRs.class);
    }

}
