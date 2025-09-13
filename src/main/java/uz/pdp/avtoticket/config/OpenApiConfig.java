package uz.pdp.avtoticket.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
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
//
//    private static final Map<String, String[]> GROUPS = new HashMap<>() {{
//        put("user", new String[]{"/avtoticket/user/**"});
//        put("auth", new String[]{"/avtoticket/auth/**"});
//        put("route", new String[]{"/avtoticket/route/**"});
//        put("bus", new String[]{"/avtoticket/bus/**", "/avtoticket/bus-model/**", "/avtoticket/bus/seats/**"});
//        put("address", new String[]{"/avtoticket/country/**", "/avtoticket/region/**", "/avtoticket/district/**"});
//        put("ticket", new String[]{"/avtoticket/ticket/**"});
//        put("order", new String[]{"/avtoticket/order/**"});
//        put("payment", new String[]{"/avtoticket/payment/**"});
//        put("trip", new String[]{"/avtoticket/trip/**"});
//        put("report", new String[]{"/avtoticket/report/**"});
//        put("user-manage", new String[]{"/avtoticket/super-admin/**"});
//        put("driver-manage", new String[]{"/avtoticket/driver/**"});
//    }};

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
                .pathsToMatch("/avtoticket/user/**")
                .build();
    }

    @Bean
    public GroupedOpenApi auth() {
        return GroupedOpenApi.builder()
                .group("auth")
                .pathsToMatch("/avtoticket/auth/**")
                .build();
    }

    @Bean
    public GroupedOpenApi route() {
        return GroupedOpenApi.builder()
                .group("route")
                .pathsToMatch("/avtoticket/route/**")
                .build();
    }

    @Bean
    public GroupedOpenApi bus() {
        return GroupedOpenApi.builder()
                .group("bus")
                .pathsToMatch("/avtoticket/bus/**",
                        "/avtoticket/bus-model/**",
                        "/avtoticket/bus/seats/**")
                .build();
    }

    @Bean
    public GroupedOpenApi address() {
        return GroupedOpenApi.builder()
                .group("address")
                .pathsToMatch("/avtoticket/country/**",
                        "/avtoticket/region/**",
                        "/avtoticket/district/**")
                .build();
    }

    @Bean
    public GroupedOpenApi ticket() {
        return GroupedOpenApi.builder()
                .group("ticket")
                .pathsToMatch("/avtoticket/ticket/**")
                .build();
    }

    @Bean
    public GroupedOpenApi order() {
        return GroupedOpenApi.builder()
                .group("order")
                .pathsToMatch("/avtoticket/order/**")
                .build();
    }

    @Bean
    public GroupedOpenApi payment() {
        return GroupedOpenApi.builder()
                .group("payment")
                .pathsToMatch("/avtoticket/payment/**")
                .build();
    }

    @Bean
    public GroupedOpenApi trip() {
        return GroupedOpenApi.builder()
                .group("trip")
                .pathsToMatch("/avtoticket/trip/**")
                .build();
    }

    @Bean
    public GroupedOpenApi report() {
        return GroupedOpenApi.builder()
                .group("report")
                .pathsToMatch("/avtoticket/report/**")
                .build();
    }

    @Bean
    public GroupedOpenApi userManage() {
        return GroupedOpenApi.builder()
                .group("user-manage")
                .pathsToMatch("/avtoticket/super-admin/**")
                .build();
    }
    @Bean
    public GroupedOpenApi driverManage() {
        return GroupedOpenApi.builder()
                .group("driver-manage")
                .pathsToMatch("/avtoticket/admin/driver/**")
                .build();
    }
}
