package com.university.university_management_system.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("University Management System")
                        .version("1.0")
                        .description("REST API for University Management System")
                        .contact(new Contact()
                                .name("Abdul Basit")
                                .email("basitirfan099@outlook.com"))
                );

    }
}


