package com.msa.template.coffee.microservices.core.coupon.repository;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
//@DataMongoTest
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {"spring.data.mongodb.port: 27017"})
public class CouponServiceImpleTest {

	@Autowired
	private WebTestClient client;

	@Autowired
	private CouponRepository repository;

	@Before
	public void setupDb(){
		System.out.println("Set up DB!!!");
		repository.deleteAll();
	}

	@Test
	public void findByMemberId(){
		Long memberId = 1L;
		getAndVerifyCouponDtoList(memberId, HttpStatus.OK)
		.jsonPath("$.memberId").isEqualTo(memberId);
	}

	private WebTestClient.BodyContentSpec getAndVerifyCouponDtoList(Long memberId, HttpStatus expectedStatus){
		return client.get()
				.uri("/coupon" + memberId)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody();
	}

}
