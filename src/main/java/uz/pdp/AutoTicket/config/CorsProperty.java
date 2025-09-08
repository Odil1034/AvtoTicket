package uz.pdp.AutoTicket.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 07/09/2025 19:53
 */

@Getter
@Setter
@Component
@ConfigurationProperties("cors")
public class CorsProperty {
    private List<String> allowedHeaders;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private String urlPattern;
    private boolean allowCredentials;
}


