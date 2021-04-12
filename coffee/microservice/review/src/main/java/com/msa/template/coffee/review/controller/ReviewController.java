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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController extends BaseController{

    private final Scheduler scheduler;
    private final ReviewRepository reviewRepository;

    public Flux<ReviewDto> getReviewByProductId(long productId) {
        if( productId < 1)
            throw new InvalidInputException("Invalid productId : " + productId);
         return asyncFlux(getByProductId(productId));
    }

    public Flux<ReviewDto> getReviewByUserId(HttpServletRequest request) {
        long userId = getUserId(request);
        if( userId < 1)
            throw new InvalidInputException("Invalid userId : " + userId);

        return asyncFlux(getByUserId(userId));

    }

    private List<ReviewDto> getByUserId(long userId) {
        List<ReviewDto> reviewDtoList = reviewRepository.findAllByUserId(userId).stream()
                .map(ReviewDto::new)
                .collect(toList());

        log.debug("getByUserId : response size : {}", reviewDtoList.size());
        return reviewDtoList;
    }

    protected List<ReviewDto> getByProductId(long productId) {

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
