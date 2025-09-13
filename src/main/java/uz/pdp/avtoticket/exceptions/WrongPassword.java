package uz.pdp.avtoticket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.pdp.avtoticket.utils.ErrorCode;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Data is deleted")
public class WrongPassword extends BaseException {

    public WrongPassword(String message, Object... args) {
        super(HttpStatus.BAD_REQUEST, ErrorCode.WRONG_PASSWORD.getMessage(), message, args);
    }
}
