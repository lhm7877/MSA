package com.msa.template.coffee.order.handler;

import com.msa.template.coffee.order.handler.rqrs.OrderCancelRq;
import com.msa.template.coffee.order.handler.rqrs.OrderCancelRs;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderCancelHandler {

    public Mono<ServerResponse> cancel(ServerRequest request) {
        Mono<OrderCancelRq> orderCancelRqMono = request.bodyToMono(OrderCancelRq.class);

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

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(rs), OrderCancelRs.class);
    }

}
