//package uz.pdp.AvtoTicket.config;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.models.ExternalDocumentation;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@OpenAPIDefinition
//public class OpenApiConfig {
//
//    @Bean
//    public OpenAPI springAutoTicketOpenAPI() {
//        return new OpenAPI().info(getInfo().license(license())).externalDocs(externalDocumentation());
//    }
//
//    private License license() {
//        return new License()
//                .name("Apache 2.0")
//                .url("http://springdoc.org");
//    }
//
//    private Info getInfo() {
//        return new Info()
//                .title("Simple Open API Configuration")
//                .description("Simple OpenAPI")
//                .version("v1");
//    }
//
//    private ExternalDocumentation externalDocumentation() {
//        return new ExternalDocumentation()
//                .description("AutoTicket documentation")
//                .url("https://autoticket.docs");
//    }
//}
