package com.msa.template.coffee.composite.product.service;


import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import com.msa.template.coffee.api.core.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static reactor.core.publisher.Flux.empty;

@Slf4j
public class ProductCompositeIntegration implements ReviewService {

    private final WebClient webClient;

    @Value("${coffee.review.api-url}")
    private String reviewServiceUrl;

    public ProductCompositeIntegration(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    @Override
    public Flux<ReviewDto> getReviewsByProductId(int productId) {
        String url = reviewServiceUrl + "/review?productId=" + productId;

        log.debug("Will call the getReviews API on URL: {}", url);

        // Return an empty result if something goes wrong to make it possible for the composite service to return partial responses
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

        log.debug("Will call the getReviews API on URL: {}", url);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(ReviewDto.class)
                .log()
                .onErrorResume(error -> empty());
    }
}
