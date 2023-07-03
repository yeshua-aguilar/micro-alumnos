package com.edu.certus.alumnos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;



@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.edu.certus.alumnos"))
				.paths(PathSelectors.ant("/alumnos1/**"))
				/*.paths(PathSelectors.any())*/
				/*  sin_restriccion**/
				.build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Microservicio Alumnos")
				.description("API para administrar información de alumnos")
				.version("1.0")
				.contact(new Contact("Kenia Ventura", "", "76987616@certus.edu.pe"))
				.license("")
				.licenseUrl("")
				.build();
		
	}
}