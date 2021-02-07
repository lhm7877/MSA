package com.msa.config;

import com.zaxxer.hikari.HikariDataSource;
import org.h2.tools.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.SQLException;

// 인텔리제이 DB CLIENT 로 접속하기위해 H2 서버 환경을 설정
@Configuration
@EnableJpaRepositories("com.msa.jparepository")
public class JpaConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSource() throws SQLException{
        
        // Datasource 가 먼저 서버에 접속 요청하는 일이 업도록, 9092포트로 먼저 H2서버를 띄워준다
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
}
