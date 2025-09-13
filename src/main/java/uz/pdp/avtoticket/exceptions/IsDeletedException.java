package uz.pdp.avtoticket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import uz.pdp.avtoticket.utils.ErrorCode;

@Getter
public class IsDeletedException extends BaseException {

    public IsDeletedException(String message, Object... args) {
        super(HttpStatus.NO_CONTENT, ErrorCode.USER_ALREADY_EXISTS.getMessage(), message, args);
    }
}
