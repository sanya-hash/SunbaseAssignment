package com.sunbasedata.records.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScans(value = {
        @ComponentScan("com.sunbasedata.records.service")
})

public class AppConfig {
	
//	@Bean
//	public SessionFactory getSessionFactory() {
//		return HibernateUtil.openSession();
//	}
	
//	@Bean
//	public UserDaoImpl getUserDao() {
//		return new UserDaoImpl();
//	}
//
//	@Bean
//	public UserServiceImpl getUserValidator() {
//		return new UserServiceImpl();
//	}
//	@Bean
//	public BookServiceImpl getBooks() {
//		return new BookServiceImpl();
//	}
//	@Bean 
//	public AuthorServiceImpl getAuthors() {
//		return new AuthorServiceImpl();
//	}
	
}