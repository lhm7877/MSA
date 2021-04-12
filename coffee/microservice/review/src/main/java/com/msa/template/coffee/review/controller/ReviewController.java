package com.msa.template.coffee.review.controller;

import com.msa.template.coffee.review.dto.ReviewDto;
import com.msa.template.coffee.review.entity.ReviewEntity;
import com.msa.template.coffee.review.exception.InvalidInputException;
import com.msa.template.coffee.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final Scheduler scheduler;
    private final ReviewRepository reviewRepository;

    public Flux<ReviewDto> getReview(int productId) {
        if( productId < 1)
            throw new InvalidInputException("Invalid productId : " + productId);
         return asyncFlux(getByProductId(productId));
    }

    protected List<ReviewDto> getByProductId(int productId) {

        List<ReviewDto> reviewDtoList =
                reviewRepository.findAllByProductId(productId).stream()
                .map(ReviewDto::new)
                .collect(toList());

        log.debug("getByProductId : response size : {}", reviewDtoList.size());

        return reviewDtoList;

    }

    private <T> Flux<T> asyncFlux(Iterable<T> iterable) {
        return Flux.fromIterable(iterable).publishOn(scheduler);
    }
}
