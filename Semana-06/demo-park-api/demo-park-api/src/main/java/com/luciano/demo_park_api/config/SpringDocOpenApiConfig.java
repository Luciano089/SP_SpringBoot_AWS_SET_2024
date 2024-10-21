package com.luciano.demo_park_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                        .title("REST API - Spring park")
                                .description("API for vehicle parking management")
                                .version("1.0")
                                .contact(new Contact().name("Luciano Sena").email("luciano@gmail.com"))

                );
    }
}
