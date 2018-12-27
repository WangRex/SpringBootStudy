package com.boot.study.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.study.filter.HelloFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		HelloFilter filter = new HelloFilter();
		bean.setFilter(filter);
		bean.addUrlPatterns("/*");

		return bean;
	}
}
