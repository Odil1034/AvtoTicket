package uz.pdp.AvtoTicket.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import uz.pdp.AvtoTicket.dto.ErrorBodyDTO;

import java.io.PrintWriter;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final ObjectMapper objectMapper;
    private final AccessDeniedHandler accessDeniedHandler;
    private final AuthenticationEntryPoint authenticationEntryPoint;

    String[] WHITE_LIST = {
            "/auth/login",
            "/auth/signup",
            "/user/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/api-docs"
    };

    @Bean
    @Lazy
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> {
                    auth.requestMatchers("/**").authenticated();
                    auth.requestMatchers(WHITE_LIST).permitAll();
                }
        );
        http.exceptionHandling((handler) -> {
            handler.accessDeniedHandler(accessDeniedHandler);
            handler.authenticationEntryPoint(authenticationEntryPoint);
        });
        http.userDetailsService(customUserDetailsService);
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (req, resp, authenticationException) -> {
            ErrorBodyDTO errorDto = new ErrorBodyDTO(
                    HttpStatus.UNAUTHORIZED.value(),
                    req.getRequestURI(),
                    req.getRequestURL().toString(),
                    authenticationException.getClass().toString(),
                    authenticationException.getMessage(),
                    LocalDateTime.now()
            );
            PrintWriter writer = resp.getWriter();
            ObjectWriter objectWriter = objectMapper.writer();
            objectWriter.writeValue(writer, errorDto);
        };
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (req, resp, accessDeniedException) -> {
            ErrorBodyDTO errorDto = new ErrorBodyDTO(
                    HttpStatus.FORBIDDEN.value(),
                    req.getRequestURI(),
                    req.getRequestURL().toString(),
                    accessDeniedException.getClass().toString(),
                    accessDeniedException.getMessage(),
                    LocalDateTime.now()
            );
            PrintWriter writer = resp.getWriter();
            ObjectWriter objectWriter = objectMapper.writer();
            objectWriter.writeValue(writer, errorDto);

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
