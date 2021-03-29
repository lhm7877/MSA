package com.jinwon.msa.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Profile(value = "local")
@Configuration
public class H2Config {

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }

}
