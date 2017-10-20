package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.spring.*")
public class Config {
	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
	
	@Autowired
	Environment environment;
	
	/**
	 * 配置HikariDataSource
	 * 相关参数从配置文件读取
	 * @return
	 */
	@Bean
	public HikariDataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(environment.getProperty("ds.driverClassName"));
		dataSource.setJdbcUrl(environment.getProperty("ds.url"));
		dataSource.setUsername(environment.getProperty("ds.userName"));
		dataSource.setPassword(environment.getProperty("ds.passWord"));
		return dataSource;
	}
	
}
