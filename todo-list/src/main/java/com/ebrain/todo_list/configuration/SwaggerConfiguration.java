package com.ebrain.todo_list.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI CustomOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("To-Do List API")
						.description("This is a Spring Boot REST API for managing to-do tasks."));
				        
	}
}
