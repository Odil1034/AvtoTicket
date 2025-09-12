package uz.pdp.avtoticket.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import uz.pdp.avtoticket.dto.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 17:48
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ErrorResponse notFoundException(HttpServletRequest req, BaseException ex) {
        return new ErrorResponse(
                String.valueOf(ex.getHttpStatus().value()),
                req.getRequestURI(),
                req.getRequestURL().toString(),
                null,
                ex.getMessage(),
                LocalDateTime.now()
        );
    }
}
