package com.msa.template.coffee.microservices.core.coupon.repository;

import com.msa.template.coffee.microservices.core.coupon.entity.CouponEntity;
import com.msa.template.coffee.microservices.core.coupon.entity.CouponStatus;
import com.msa.template.coffee.microservices.core.coupon.repository.CouponRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CouponServiceTest {

	@Autowired
	private CouponRepository repository;
	private CouponEntity savedEntity;

	@Before
	public void setupDb(){
		System.out.println("Set up DB!!!");
		repository.deleteAll();

		CouponEntity entity = new CouponEntity("coupon-number1", "product-id", "product-name", 3500, 1L, new Date(System.currentTimeMillis()), CouponStatus.UNUSED);
		savedEntity = repository.save(entity);
	}


	@Test
	public void create(){
		CouponEntity entity = new CouponEntity("coupon-number2", "product-id", "product-name", 3000, 1L, new Date(System.currentTimeMillis()), CouponStatus.UNUSED);
		savedEntity = repository.save(entity);

		List<CouponEntity> findEntityList = repository.findByMemberId(1L);
		System.out.println("===============================");
		System.out.println("==                          ===");
		System.out.println("==            create        ===");
		System.out.println("==                          ===");
		System.out.println("===============================");
		for(CouponEntity couponEntity : findEntityList){
			System.out.println(couponEntity);
		}
	}

	@Test
	public void findByMemberId(){
		List<CouponEntity> findEntityList = repository.findByMemberId(1L);
		System.out.println("===============================");
		System.out.println("==                          ===");
		System.out.println("==            find          ===");
		System.out.println("==                          ===");
		System.out.println("===============================");
		for(CouponEntity couponEntity : findEntityList){
			System.out.println(couponEntity);
		}
	}

	/*
	Set up DB!!!
	2021-05-25 00:23:52.555  INFO 12976 --- [       Thread-4] o.s.b.a.mongo.embedded.EmbeddedMongo     : 2021-05-25T00:23:52.555+0900 I NETWORK  [thread1] connection accepted from 127.0.0.1:50910 #3 (3 connections now open)
	2021-05-25 00:23:52.555  INFO 12976 --- [       Thread-4] o.s.b.a.mongo.embedded.EmbeddedMongo     : 2021-05-25T00:23:52.556+0900 I NETWORK  [conn3] received client metadata from 127.0.0.1:50910 conn3: { driver: { name: "mongo-java-driver|sync|spring-boot", version: "4.1.2" }, os: { type: "Windows", name: "Windows 10", architecture: "amd64", version: "10.0" }, platform: "Java/Oracle Corporation/11.0.10+8-LTS-162" }
	2021-05-25 00:23:52.556  INFO 12976 --- [    Test worker] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:3, serverValue:3}] to localhost:27017
	===============================
	==                          ===
	==            create        ===
	==                          ===
	===============================
	CouponEntity{id='60abc50894340b1909e516a3', couponNumber='coupon-number1', productId='product-id', productName='product-name', productPrice=3500, memberId=1, expirationDate='2021-05-24 11:51:13', couponStatus=UNUSED}
	CouponEntity{id='60abc50894340b1909e516a4', couponNumber='coupon-number2', productId='product-id', productName='product-name', productPrice=3000, memberId=1, expirationDate='2021-05-24 11:51:13', couponStatus=UNUSED}
	Set up DB!!!
	===============================
	==                          ===
	==            find          ===
	==                          ===
	===============================
	CouponEntity{id='60abc50894340b1909e516a5', couponNumber='coupon-number1', productId='product-id', productName='product-name', productPrice=3500, memberId=1, expirationDate='2021-05-24 11:51:13', couponStatus=UNUSED}
	*/


}
