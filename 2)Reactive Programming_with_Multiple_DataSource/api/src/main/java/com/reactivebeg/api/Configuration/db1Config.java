package com.reactivebeg.api.Configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "DB1EntityManagerFactoryBean", basePackages = "com.reactivebeg.api.Repository.DB1Repo", transactionManagerRef = "DB1TransactionManager")
public class db1Config {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource db1DataSource() {

        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean DB1EntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(db1DataSource());
        emf.setPackagesToScan(new String[] { "com.reactivebeg.api.Entity.DB1Entity" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        // vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        emf.setJpaVendorAdapter(vendorAdapter);
        return emf;
    }

    @Primary
    @Bean
    public PlatformTransactionManager DB1TransactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(DB1EntityManagerFactoryBean().getObject());
        return manager;
    }

}
