package com.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MsaApplication {

    public static void main(String[] argv){
        SpringApplication.run(MsaApplication.class);
    }
}
