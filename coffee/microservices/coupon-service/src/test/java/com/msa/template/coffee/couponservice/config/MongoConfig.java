//package com.msa.template.coffee.couponservice.config;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
//@Configuration
//@EnableReactiveMongoRepositories(basePackageClasses = "com.msa.template.coffee.couponservice.repository"
//        , reactiveMongoTemplateRef = "userMongoTemplate")
//public class MongoConfig {
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create("mongodb://localhost:27017");
//    }
//
//    @Bean
//    public ReactiveMongoTemplate userMongoTemplate(MongoClient mongoClient) {
//        return new ReactiveMongoTemplate(mongoClient, "USER_DB");
//    }
//}
