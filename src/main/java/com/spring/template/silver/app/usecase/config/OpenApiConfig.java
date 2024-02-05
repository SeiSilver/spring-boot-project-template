package com.spring.template.silver.app.usecase.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.spring.template.silver.app.usecase.constraint.StringConstraint.BEARER;

@Configuration
@AllArgsConstructor
public class OpenApiConfig {

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl("http://localhost:8080");
    devServer.setDescription("Server URL in Development environment");

    Contact contact = new Contact();
    contact.setEmail("test@gmail.com");
    contact.setName("test");
    contact.setUrl("http://localhost:8080/");

    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("Tutorial Management API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
        .license(mitLicense);

    SecurityScheme bearerTokenScheme = new SecurityScheme()
        .type(SecurityScheme.Type.APIKEY)
        .scheme("bearer")
        .bearerFormat("JWT")
        .in(SecurityScheme.In.HEADER)
        .name("Authorization");

    SecurityRequirement securityRequirement = new SecurityRequirement().addList(BEARER);

    return new OpenAPI()
        .info(info)
        .servers(List.of(devServer))
        .components(new io.swagger.v3.oas.models.Components()
            .addSecuritySchemes(BEARER, bearerTokenScheme))
        .addSecurityItem(securityRequirement);
  }

}