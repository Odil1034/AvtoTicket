package uz.pdp.AutoTicket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import uz.pdp.AutoTicket.utils.ErrorCode;

@Getter
public class IsDeletedException extends BaseException {

    public IsDeletedException(String message, Object... args) {
        super(HttpStatus.NO_CONTENT, ErrorCode.USER_ALREADY_EXIST, message, args);
    }
}
