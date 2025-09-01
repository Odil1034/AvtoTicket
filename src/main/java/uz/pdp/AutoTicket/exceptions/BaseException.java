package uz.pdp.AutoTicket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 21:06
 */

@Getter
public abstract class BaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final String code;

    public BaseException(HttpStatus httpStatus, String code, String message, Object... args) {
        super(MessageFormat.format(message, args));
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
