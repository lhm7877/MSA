package com.msa.template.coffee.microservices.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import com.msa.template.coffee.api.core.coupon.service.CouponService;
import com.msa.template.coffee.microservices.core.coupon.entity.CouponEntity;
import com.msa.template.coffee.microservices.core.coupon.exception.InvalidInputException;
import com.msa.template.coffee.microservices.core.coupon.repository.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CouponServiceImpl implements CouponService {

    private static final Logger logger = LoggerFactory.getLogger(CouponServiceImpl.class);

    private final CouponRepository repository;

    private final CouponMapper mapper;

    @Autowired
    public CouponServiceImpl(CouponRepository repository, CouponMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<CouponDto> createCoupon(CouponDto couponDto) {

        if(couponDto.getMemberId() < 1)
            throw new InvalidInputException("Invalid memberId : " + couponDto.getMemberId());

        CouponEntity entity = mapper.convertToEntity(couponDto);
        return repository.save(entity)
                .log()
                .map(e -> mapper.convertToDto(e));
    }

    @Override
    public Flux<CouponDto> getList(Long memberId) {
        if(memberId < 1)
            throw new InvalidInputException("Invalid memberId : " + memberId);

        return repository.findByMemberId(memberId)
                .log()
                .map(e -> mapper.convertToDto(e));
    }
}
