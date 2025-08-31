package uz.pdp.AvtoTicket.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.AvtoTicket.dto.ErrorBodyDTO;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 17:48
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IsDeletedException.class, NotFoundException.class, WrongPassword.class})
    public ErrorBodyDTO notFoundException(HttpServletRequest req, NotFoundException exception) {
        return new ErrorBodyDTO(
                exception.getStatus().value(),
                req.getRequestURI(),
                req.getRequestURL().toString(),
                exception.getCause().toString(),
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}
