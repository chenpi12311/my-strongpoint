package com.czp.mystrongpoint.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

@Configurable
public class DataRepositoryConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.dbcp2.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.dbcp2.max-open-prepared-statements}")
    private int maxOpenPreparedStatements;
    @Value("${spring.datasource.dbcp2.max-idle}")
    private int maxIdle;
    @Value("${spring.datasource.dbcp2.time-between-eviction-runs-millis}")
    private int timeBetweenEvictionRunsMills;

    @Bean("dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();

        bds.setUrl(url);
        bds.setUsername(username);
        bds.setPassword(password);
        bds.setMinIdle(minIdle);
        bds.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        bds.setMaxIdle(maxIdle);
        bds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMills);

        return bds;
    }

}
