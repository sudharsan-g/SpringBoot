
// package com.reactivebeg.api.Configuration;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
// import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
// import org.springframework.data.r2dbc.dialect.PostgresDialect;
// import
// org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
// import org.springframework.r2dbc.core.DatabaseClient;

// import io.r2dbc.spi.ConnectionFactory;

// @Configuration
// @EnableR2dbcRepositories(basePackages = {
// "com.reactivebeg.api.Repository.DB1Repo" })
// public class db1Config {

// @Bean
// @Primary
// @ConfigurationProperties("spring.r2dbc.db1")
// public ConnectionFactory connectionFactory() {

// return
// ConnectionFactoryBuilder.withUrl("r2dbc:postgresql://localhost:5432/THK")
// .username("postgres")
// .password("S@14")
// .build();

// }

// }