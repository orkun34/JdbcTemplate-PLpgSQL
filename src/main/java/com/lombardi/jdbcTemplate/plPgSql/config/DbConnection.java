package com.lombardi.jdbcTemplate.plPgSql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author orkun
 */

@Configuration
@ComponentScan("com.lombardi.jdbcTemplate.plPgSql")
@PropertySource("classpath:database.properties")
public class DbConnection {

    @Autowired
    Environment environment;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty("dbUrl"));
        driverManagerDataSource.setPassword(environment.getProperty("dbPassword"));
        driverManagerDataSource.setUsername(environment.getProperty("dbUsername"));
        driverManagerDataSource.setDriverClassName(environment.getProperty("dbDriver"));

        return driverManagerDataSource;
    }
}
