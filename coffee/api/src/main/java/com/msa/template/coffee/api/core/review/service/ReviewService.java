package com.msa.template.coffee.api.core.review.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msa.template.coffee.api.core.review.dto.ReviewDto;

import reactor.core.publisher.Flux;

public interface ReviewService {

    @GetMapping(
            value    = "/review",
            produces = "application/json")
    Flux<ReviewDto> getReviewsByProductId(@RequestParam(value = "productId") int productId);

}
