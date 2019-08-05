package com.segware.upvotes.upvotes.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

//Classe utilizada para TESTAR as requisções da API, para verificar /swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()	
				.apis(RequestHandlerSelectors.basePackage("com.segware.upvotes.upvotes"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
				
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Posts API REST",
				"API REST de cadastro de posts com upvote.",
				"1.0", 
				"Terms of Service",
				new Contact("Giovanni Jakubiak de Albuquerque", 
							"https://www.google.com", 
							"giovannijakubiak@hotmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
				);
		
		return apiInfo;
				
	}
	
}
