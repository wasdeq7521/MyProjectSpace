package com.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

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
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(HikariDataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.query.substitutions", environment.getProperty("hibernate.query.substitutions"));
		properties.setProperty("hibernate.jdbc.batch_size", environment.getProperty("hibernate.jdbc.batch_size"));
		properties.setProperty("hibernate.cache.provider_class", environment.getProperty("hibernate.cache.provider_class"));
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.setPackagesToScan(new String[] {"com.spring"});
		
		return sessionFactoryBean;
	}
	
}
