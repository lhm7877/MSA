package com.msa.template.coffee.api.core.review.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msa.template.coffee.api.core.review.dto.ReviewDto;

import reactor.core.publisher.Mono;

public interface ReviewService {

    @GetMapping(
            value    = "/review",
            produces = "application/json")
    Mono<ReviewDto> getReviewsByProductId(@RequestParam(value = "productId") int productId);

}
