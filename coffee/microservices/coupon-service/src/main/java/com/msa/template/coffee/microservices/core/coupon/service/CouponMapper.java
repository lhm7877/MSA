package com.msa.template.coffee.microservices.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import com.msa.template.coffee.microservices.core.coupon.entity.CouponEntity;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface CouponMapper {
    CouponDto convertToDto(CouponEntity entity);
    CouponEntity convertToEntity(CouponDto couponDto);
}
