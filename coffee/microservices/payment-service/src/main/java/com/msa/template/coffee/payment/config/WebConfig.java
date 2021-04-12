package com.msa.template.coffee.payment.config;

import com.msa.template.coffee.payment.controller.rqrs.RefundRs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer{


}
