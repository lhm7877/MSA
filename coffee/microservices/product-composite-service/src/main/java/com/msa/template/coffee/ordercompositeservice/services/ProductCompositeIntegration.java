package com.msa.template.coffee.ordercompositeservice.services;

import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.product.ProductVo;
import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import com.msa.template.coffee.api.core.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Flux.empty;
@Slf4j
public class ProductCompositeIntegration implements ProductService, ReviewService {

	private final WebClient webClient;

	@Value("${coffee.review.api-url}")
	private String reviewServiceUrl;

	public ProductCompositeIntegration(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}

	@Override
	public Flux<ReviewDto> getReviewsByProductId(int productId) {
		String url = reviewServiceUrl + "/review?productId=" + productId;

		log.debug("API URL : ", url);
		return webClient.get()
				.uri(url)
				.retrieve()
				.bodyToFlux(ReviewDto.class)
				.log()
				.onErrorResume(error -> empty());

	}

	@Override
	public Flux<ReviewDto> getReviewsByUserId(int userId) {
		String url = reviewServiceUrl + "/review?userId=" + userId;

		log.debug("API URL : ", url);
		return webClient.get()
				.uri(url)
				.retrieve()
				.bodyToFlux(ReviewDto.class)
				.log()
				.onErrorResume(error -> empty());
	}

	@Override
	public Mono<ProductVo> getProduct(int productId) {
		// to ProductServiceImpl
		return null;
	}

	@Override
	public Flux<ProductVo> getProducts() {
		return null;
	}
}
