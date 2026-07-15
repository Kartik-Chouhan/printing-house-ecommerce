package com.printing_house_backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI printingHouseOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Printing House E-Commerce API")
                        .description("REST APIs for Printing House E-Commerce Application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Kartik Chouhan")
                                .email("chouhankartik89@gmail.com"))
                        .license(new License()
                                .name("Private Project")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }

}