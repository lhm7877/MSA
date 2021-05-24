package com.msa.template.coffee.microservices.core.coupon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CouponServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(CouponServiceApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CouponServiceApplication.class, args);
		
		// mongo DB 연결 HOST, PORT 출력
		String mongoDbHost = ctx.getEnvironment().getProperty("spring.data.mongodb.host");
		String mongoDbPort = ctx.getEnvironment().getProperty("spring.data.mongodb.port");
		logger.info("Connected to MongoDB : " + mongoDbHost + ":" + mongoDbPort);
	}

}
