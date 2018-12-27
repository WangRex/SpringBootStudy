package com.boot.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("动物园组")
				.apiInfo(new ApiInfoBuilder().contact(new Contact("HD", "", "ssss@163.com")).build()).select()
				.paths(PathSelectors.regex("/zoos.*")).build();

		return docket;
	}
}
