package uz.pdp.AutoTicket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.pdp.AutoTicket.utils.ErrorCode;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Data is deleted")
public class WrongPassword extends BaseException {

    public WrongPassword(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, ErrorCode.WRONG_PASSWORD, message, args);
    }
}
