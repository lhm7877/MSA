package com.msa.template.coffee.review.controller;

import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import com.msa.template.coffee.api.core.review.service.ReviewService;
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
//TODO 이후민 : 책에서처런 이름을 service로 통일하는건 어때요? webflux는 MVC가 아니니까 controller가 꼭 필요하진 않을거 같아요
public class ReviewController implements ReviewService{

    private final Scheduler scheduler;
    private final ReviewRepository reviewRepository;

    @Override
    public Flux<ReviewDto> getReviewsByProductId(int productId) {
        if( productId < 1)
            throw new InvalidInputException("Invalid productId : " + productId);
        return asyncFlux(getByProductId(productId));
    }

    @Override
    public Flux<ReviewDto> getReviewsByUserId(int userId) {
        if( userId < 1)
            throw new InvalidInputException("Invalid userId : " + userId);

        return asyncFlux(getByUserId(userId));
    }


    private List<ReviewDto> getByUserId(long userId) {
        List<ReviewDto> reviewDtoList = reviewRepository.findAllByUserId(userId).stream()
                .map(e -> new ReviewDto(e.getUserId(), e.getProductId(), e.getContents(),e.getRating(), e.getUpdatedDate()))
                .collect(toList());

        log.debug("getByUserId : response size : {}", reviewDtoList.size());
        return reviewDtoList;
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
