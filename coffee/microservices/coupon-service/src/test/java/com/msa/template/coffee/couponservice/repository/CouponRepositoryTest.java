package com.msa.template.coffee.couponservice.repository;

import com.msa.template.coffee.couponservice.entity.CouponEntity;
import com.msa.template.coffee.couponservice.entity.CouponStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CouponRepositoryTest {
    private CouponRepository couponRepository;

    private Mono<CouponEntity> savedEntity;

    @Before
    public void setupDb(){
        couponRepository.deleteAll();

        CouponEntity entity = new CouponEntity("productId1", "productName2", 3500, "couponNumber1", 1L, CouponStatus.UNUSED);
        savedEntity = couponRepository.save(entity);

        savedEntity.subscribe(System.out::println);
    }

    @Test
    public void create() {
        CouponEntity newEntity = new CouponEntity("productId2", "productName2", 4500, "couponNumber2", 1L, CouponStatus.UNUSED);
        savedEntity = couponRepository.save(newEntity);

        Mono<CouponEntity> foundEntity = couponRepository.findByCouponId(newEntity.getCouponId());

        assertEquals(newEntity, foundEntity);
        assertEquals(2, couponRepository.count());
    }

}