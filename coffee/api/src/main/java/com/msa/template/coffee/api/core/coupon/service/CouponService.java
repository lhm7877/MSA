package com.msa.template.coffee.api.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponService {

    /**
     * memberId로 쿠폰 목록 조회
     *
     * @author : pjh0904
     * @date : 2021-05-11 오후 3:44
     */
    @GetMapping(
            value    = "/coupon/{memberId}",
            produces = "application/json")
    Flux<CouponDto> getList(@PathVariable int memberId);

    /**
     * 쿠폰 사용처리
     *
     * @author : pjh0904
     * @date : 2021-05-11 오후 3:44
     */
    @PostMapping(
            value = "/coupon/use",
            produces = "application/json")
    Mono<Boolean> use(CouponDto rq);
}
