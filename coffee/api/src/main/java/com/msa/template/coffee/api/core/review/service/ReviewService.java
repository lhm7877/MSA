package com.msa.template.coffee.api.core.review.service;

import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

public interface ReviewService {

    /**
     * Sample usage: curl $HOST:$PORT/review?productId=1
     *
     * @param productId
     * @return
     */
    @GetMapping(
            value    = "/review",
            produces = "application/json")
    Flux<ReviewDto> getReviewsByProductId(@RequestParam(value = "productId") int productId);


    /**
     * Sample usage: curl $HOST:$PORT/review?productId=1
     *
     * @param userId
     * @return
     */
    @GetMapping(
            value    = "/review",
            produces = "application/json")
    Flux<ReviewDto> getReviewsByUserId(@RequestParam(value = "userId") int userId);
}
