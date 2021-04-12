package com.msa.template.coffee.review.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executors;

@Slf4j
@Configuration
public class SchedulerConfig {

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private Integer maximumPoolSize;

    @Bean
    public Scheduler jdbcScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(maximumPoolSize));
    }
}
