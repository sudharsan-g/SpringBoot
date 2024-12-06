
package com.reactivebeg.api.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = { "com.reactivebeg.api.Repository.DB1Repo" })
public class db1Config {

}