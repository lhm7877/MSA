package com.msa.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

// 인텔리제이 DB CLIENT 로 접속하기위해 H2 서버 환경을 설정
@Configuration
@EnableJpaRepositories("com.msa.repository")
public class TestJpaConfig {

    private Properties jpaProperties(){
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        jpaProperties.setProperty(AvailableSettings.SHOW_SQL, "true");
        jpaProperties.setProperty(AvailableSettings.FORMAT_SQL, "true");
        return jpaProperties;
    }

    @Bean
    public DataSource dataSource() throws SQLException{
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb")
                .password("")
                .username("sa")
                .driverClassName("org.h2.Driver")
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(this.dataSource());
        emfb.setPackagesToScan("com.msa.entity");
        emfb.setJpaProperties(jpaProperties());
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setPersistenceUnitName("msa");
        return emfb;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new JpaTransactionManager(this.entityManagerFactory().getObject());
    }
}
