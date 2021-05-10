package com.msa.template.coffee.review.controller;

import static java.util.stream.Collectors.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import com.msa.template.coffee.api.core.review.service.ReviewService;
import com.msa.template.coffee.review.exception.InvalidInputException;
import com.msa.template.coffee.review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;

@Slf4j
@RestController
@RequiredArgsConstructor
//XXX 이후민 : 책에서처런 이름을 service로 통일하는건 어때요? webflux는 MVC가 아니니까 controller가 꼭 필요하진 않을거 같아요
// 작은 프로젝트니까 service만드로 해도 될거같지만 reviewservice를 controller로 바꾸고 service를 따로 만드는것도 좋아보인다.
public class ReviewController implements ReviewService{

    private final Scheduler scheduler;
    private final ReviewRepository reviewRepository;

    @Override
    public Flux<ReviewDto> getReviewsByProductId(int productId) {
        if( productId < 1)
            throw new InvalidInputException("Invalid productId : " + productId);
        return asyncFlux(getByProductId(productId));
    }

    protected List<ReviewDto> getByProductId(long productId) {
        List<ReviewDto> reviewDtoList = reviewRepository.findAllByProductId(productId).stream()
                .map(e -> new ReviewDto(e.getUserId(), e.getProductId(), e.getContents(),e.getRating(), e.getUpdatedDate()))
                .collect(toList());

        log.debug("getByProductId : response size : {}", reviewDtoList.size());

        return reviewDtoList;

    }

    private <T> Flux<T> asyncFlux(Iterable<T> iterable) {
        return Flux.fromIterable(iterable).publishOn(scheduler);
    }
}
