package uz.pdp.AvtoTicket.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI springAutoTicketOpenAPI() {
        return new OpenAPI()
                .servers(getServers())
                .info(getInfo()
                    .license(license()))
                .externalDocs(externalDocumentation());
    }

    private List<Server> getServers() {
        return List.of(new Server()
                .url("http://localhost:8080")
                .description("Local Development Server"));

    }

    private License license() {
        return new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");
    }

    private io.swagger.v3.oas.models.info.Info getInfo() {
        return new io.swagger.v3.oas.models.info.Info()
                .title("AvtoTicket Management System")
                .description("This API provides functionalities to manage buses, tickets, users, and roles. \"\n" +
                        "                        + \"Users can browse available tickets, book them, \"\n" +
                        "                        + \"and manage users, roles, and related operations effectively.\"")
                .version("v1.0.0");
    }

    private ExternalDocumentation externalDocumentation() {
        return new ExternalDocumentation()
                .description("AutoTicket documentation")
                .url("https://autoticket.docs");
    }

    @Bean
    public GroupedOpenApi openApi(){
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/user/**")
                .build();
    }
}
