package uz.pdp.avtoticket.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import uz.pdp.avtoticket.dto.ErrorResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import uz.pdp.avtoticket.utils.ErrorCode;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 07:21
 */

@Configuration
@RequiredArgsConstructor
public class SecurityBeanConfiguration {

    private final ObjectMapper objectMapper;

//    private final int ERROR_CODE_ACCESS_DENIED = 403;
//    private final int ERROR_CODE_UNAUTHORIZED = 401;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (req, resp, e)
                -> handler(req, resp, ErrorCode.ACCESS_DENIED.getStatus(), e, ErrorCode.ACCESS_DENIED.getMessage());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (req, resp, e)
                -> handler(req, resp, ErrorCode.AUTHENTICATION_ENTRY_POINT.getStatus(), e, ErrorCode.AUTHENTICATION_ENTRY_POINT.getMessage());
    }

    @SneakyThrows
    private void handler(HttpServletRequest request, HttpServletResponse response, HttpStatus errorCode, Exception exception, String message) {
        ErrorResponse errorDto = new ErrorResponse(
                String.valueOf(errorCode),
                request.getRequestURI(),
                request.getRequestURL().toString(),
                exception.getClass().toString(),
                message,
                LocalDateTime.now());

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            objectMapper.writeValue(outputStream, errorDto);
        }
    }
}
