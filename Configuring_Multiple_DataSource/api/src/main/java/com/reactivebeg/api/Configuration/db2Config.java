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
@EnableJpaRepositories(entityManagerFactoryRef = "DB2EntityManagerFactoryBean", basePackages = "com.reactivebeg.api.Repository.DB2Repo", transactionManagerRef = "DB2TransactionManager")
public class db2Config {

    @Bean
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean DB2EntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(db2DataSource());
        emf.setPackagesToScan(new String[] { "com.reactivebeg.api.Entity.DB2Entity" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        // vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        emf.setJpaVendorAdapter(vendorAdapter);
        return emf;
    }

    @Bean
    public PlatformTransactionManager DB2TransactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(DB2EntityManagerFactoryBean().getObject());
        return manager;
    }

}
