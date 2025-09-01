package uz.pdp.AutoTicket.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import uz.pdp.AutoTicket.dto.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 17:48
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IsDeletedException.class, NotFoundException.class, WrongPassword.class})
    public ErrorResponse notFoundException(HttpServletRequest req, NotFoundException exception) {
        return new ErrorResponse(
                String.valueOf(exception.getStatus().value()),
                req.getRequestURI(),
                req.getRequestURL().toString(),
                exception.getCause().toString(),
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}
