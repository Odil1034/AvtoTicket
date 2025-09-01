package uz.pdp.AutoTicket.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import uz.pdp.AutoTicket.dto.ErrorResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 07:21
 */

@Configuration
@RequiredArgsConstructor
public class SecurityBeanConfiguration {

    private final ObjectMapper objectMapper;

    private final int ERROR_CODE_ACCESS_DENIED = 403;
    private final int ERROR_CODE_UNAUTHORIZED = 401;


    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (req, resp, e) -> handler(req, resp, ERROR_CODE_ACCESS_DENIED, e);
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (req, resp, e) -> handler(req, resp, ERROR_CODE_UNAUTHORIZED, e);
    }

    @SneakyThrows
    private void handler(HttpServletRequest request, HttpServletResponse response, int errorCode, Exception exception) {
        ErrorResponse errorDto = new ErrorResponse(
                String.valueOf(errorCode),
                request.getRequestURI(),
                request.getRequestURL().toString(),
                exception.getClass().toString(),
                exception.getMessage(),
                LocalDateTime.now());

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            objectMapper.writeValue(outputStream, errorDto);
        }
    }
}
