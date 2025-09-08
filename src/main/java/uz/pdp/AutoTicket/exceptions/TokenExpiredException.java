package uz.pdp.AutoTicket.exceptions;

import org.springframework.http.HttpStatus;
import uz.pdp.AutoTicket.utils.ErrorCode;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 11:33
 */
public class TokenExpiredException extends BaseException {
    public TokenExpiredException(String message, Object... args) {
        super(HttpStatus.UNAUTHORIZED, ErrorCode.TOKEN_EXPIRED, message, args);
    }
}
