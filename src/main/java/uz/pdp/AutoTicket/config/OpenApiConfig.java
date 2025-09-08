package uz.pdp.AutoTicket.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Avto Ticket Application")
                        .description("This API provides that allows you to purchase and manage bus tickets online. The application is designed to manage users, buses, trips, orders, and payments.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Baxriddinov Odiljon")
                                .email("odiljonbaxriddinov735@gmail.com")
                                .url("t.me/Odil1034")
                                .url("https://github.com/Odil1034"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("https://docs.spring.io/spring-boot/index.html"))
                .externalDocs(new ExternalDocumentation()
                        .description("Avto Ticket Application")
                        .url("https://aticketdoc.wiki.github.org/docs"))
                .servers(List.of((
                        new Server().url("http://localhost:8080").description("Testing Server")
                )))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .addSecurityItem(new io.swagger.v3.oas.models.security.SecurityRequirement()
                        .addList("bearer-jwt"));
    }

    @Bean
    public GroupedOpenApi all() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi user() {
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/autoticket/user/**")
                .build();
    }

    @Bean
    public GroupedOpenApi auth() {
        return GroupedOpenApi.builder()
                .group("auth")
                .pathsToMatch("/autoticket/auth/**")
                .build();
    }

    @Bean
    public GroupedOpenApi route() {
        return GroupedOpenApi.builder()
                .group("route")
                .pathsToMatch("/autoticket/route/**")
                .build();
    }

    @Bean
    public GroupedOpenApi bus() {
        return GroupedOpenApi.builder()
                .group("bus")
                .pathsToMatch("/autoticket/bus/**")
                .build();
    }

    @Bean
    public GroupedOpenApi address() {
        return GroupedOpenApi.builder()
                .group("address")
                .pathsToMatch("/autoticket/address/**")
                .build();
    }

}
