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

import java.util.List;
import java.util.stream.Collectors;

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
    public CouponDto createCoupon(CouponDto couponDto) {
        try {
            CouponEntity entity = mapper.convertToEntity(couponDto);
            CouponEntity newEntity = repository.save(entity);

            logger.debug("===================create couponDto===================");
            logger.debug(newEntity.toString());

            return mapper.convertToDto(newEntity);

        }catch (Exception e){
            logger.error(e.getMessage());
            throw new InvalidInputException(e.getMessage());
        }
    }

    @Override
    public List<CouponDto> getList(Long memberId) {

        try {
            List<CouponDto> couponDtoList = repository.findByMemberId(memberId).stream()
                    .map(entity -> mapper.convertToDto(entity))
                    .collect(Collectors.toList());

            for (CouponDto couponDto : couponDtoList){
                logger.debug(couponDto.toString());
            }

            return couponDtoList;

        } catch (Exception e){
            logger.error(e.getMessage());
            throw new InvalidInputException(e.getMessage());
        }
    }
}
