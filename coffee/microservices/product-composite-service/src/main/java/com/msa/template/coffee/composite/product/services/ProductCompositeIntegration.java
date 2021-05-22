package com.msa.template.coffee.composite.product.services;

import static reactor.core.publisher.Flux.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.api.core.order.dto.SuccessDto;
import com.msa.template.coffee.api.core.order.service.OrderService;
import com.msa.template.coffee.api.core.product.ProductDto;
import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import com.msa.template.coffee.api.core.review.service.ReviewService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class ProductCompositeIntegration implements ProductService, ReviewService, OrderService {

	private final WebClient webClient;


	@Value("${coffee.review.api-url}")
	private String reviewServiceUrl;

	public ProductCompositeIntegration(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}

	@Override
	public Mono<ReviewDto> getReviewsByProductId(int productId) {
		String url = reviewServiceUrl + "/review?productId=" + productId;

		// log.debug("API URL : ", url);
		return webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(ReviewDto.class)
				.log()
				.onErrorResume(error -> Mono.empty());

	}

	@Override
	public Mono<ProductDto> getProduct(int productId) {
		// to ProductServiceImpl
		return null;
	}

	@Override
	public Flux<ProductDto> getProducts() {
		String url = "http://localhost:8080/products";

		return webClient.get()
			.uri(url)
			.retrieve()
			.bodyToFlux(ProductDto.class)
			.log()
			.onErrorResume(error -> empty());
	}

	@Override
	public Mono<SuccessDto> order(OrderDto rq) {
		String orderServiceUrl = "localhost";
		final String url = orderServiceUrl + "/order";
		/*
         API member service
         checkMemberSn();
        */


        /*
         API goods service
        */

		return webClient.post()
				.uri(url)
				.bodyValue(rq)
				.retrieve()
				.bodyToMono(SuccessDto.class);
	}

	@Override
	public Flux<SuccessDto> cancel(OrderCancelDto rq) {
		return null;
	}

	@Override
	public Mono<List<OrderLoadDto>> getList(int memberId) {
		return null;
	}
}
