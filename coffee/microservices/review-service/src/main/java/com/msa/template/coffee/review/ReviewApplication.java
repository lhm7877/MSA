package com.msa.template.coffee.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//TODO : 이후민 : 이건 머징하면서 잘못 추가된거인듯
@EnableJpaAuditing
@SpringBootApplication
public class ReviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class);
    }
}
