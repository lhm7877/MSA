package com.msa.template.coffee.order.config;

import com.msa.template.coffee.order.handler.OrderCancelHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@EnableWebFlux
public class OrderRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(OrderCancelHandler handler) {
        return RouterFunctions
                .route(POST("/order/cancel").and(accept(MediaType.APPLICATION_JSON)), handler::cancel);
    }

}
