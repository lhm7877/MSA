package com.msa.template.coffee.composite.product.services;

import static reactor.core.publisher.Flux.*;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import com.msa.template.coffee.api.core.coupon.service.CouponService;
import com.msa.template.coffee.api.core.member.dto.MemberDto;
import com.msa.template.coffee.api.core.member.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.api.core.order.dto.SuccessDto;
import com.msa.template.coffee.api.core.order.service.OrderService;
import com.msa.template.coffee.api.core.product.ProductDto;
import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.review.dto.ReviewDto;
import com.msa.template.coffee.api.core.review.service.ReviewService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class ProductCompositeIntegration implements ProductService, ReviewService, OrderService, CouponService, MemberService {

	private final WebClient webClient;


	@Value("${coffee.review.api-url}")
	private String reviewServiceUrl;

	@Value("${coffee.order-api}")
	private String orderServiceUrl;

	@Value("${coffee.product-api}")
	private String productServiceUrl;


	public ProductCompositeIntegration(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}

	@Override
	public Mono<ReviewDto> getReviewsByProductId(int productId) {
		String url = reviewServiceUrl + "/review?productId=" + productId;

		// log.debug("API URL : ", url);
		return webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(ReviewDto.class)
				.log()
				.onErrorResume(error -> Mono.empty());

	}

	@Override
	public Mono<ProductDto> getProduct(int productId) {
		// to ProductServiceImpl
		return null;
	}

	@Override
	public Flux<ProductDto> getProducts() {
		String url = productServiceUrl + "/products";

		return webClient.get()
			.uri(url)
			.retrieve()
			.bodyToFlux(ProductDto.class)
			.log()
			.onErrorResume(error -> empty());
	}

	@Override
	public Mono<SuccessDto> order(OrderDto rq) {
		final String url = orderServiceUrl + "/order";
		/*
         API member service
         checkMemberSn();
        */


        /*
         API goods service
        */

		return webClient.post()
				.uri(url)
				.bodyValue(rq)
				.retrieve()
				.bodyToMono(SuccessDto.class);
	}

	@Override
	public Flux<SuccessDto> cancel(OrderCancelDto rq) {
		return null;
	}

	@Override
	public Mono<List<OrderLoadDto>> getList(int memberId) {
		return null;
	}

	@Override
	public Mono<MemberDto> memberById(int memberId) {
		String url = "http://localhost:8080/member";

		return webClient.post()
				.uri(url)
				.bodyValue(memberId)
				.retrieve()
				.bodyToMono(MemberDto.class);
	}

	@Override
	public Flux<MemberDto> memberList() {
		String url = "http://localhost:8080/members";

		return webClient.get()
				.uri(url)
				.retrieve()
				.bodyToFlux(MemberDto.class);
	}

	@Override
	public Mono<CouponDto> createCoupon(CouponDto couponDto) {
		return webClient.post()
				.uri("/coupon")
				.bodyValue(couponDto)
				.retrieve()
				.bodyToMono(CouponDto.class)
				.log();
	}

	@Override
	public Flux<CouponDto> getList(Long memberId) {
		return webClient.get()
				.uri("/coupon" + memberId)
				.retrieve()
				.bodyToFlux(CouponDto.class)
				.log();
	}
}
