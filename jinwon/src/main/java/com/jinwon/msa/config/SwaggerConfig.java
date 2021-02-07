package com.jinwon.msa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    private static final String TITLE = "MSA_JINWON";
    private static final String VERSION = "v0.0.1";
    private static final String DESCRIPTION = "진원 MSA 스터디용";
    private static final String LICENSE = "FOR JINWON";
    private static final String LICENSE_URL = "https://github.com/lhm7877/MSA/tree/jinwon";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jinwon.msa"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .version(VERSION)
                .description(DESCRIPTION)
                .license(LICENSE)
                .licenseUrl(LICENSE_URL)
                .build();
    }

}
