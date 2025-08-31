package uz.pdp.AvtoTicket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Data is deleted")
public class WrongPassword extends RuntimeException {

    private final HttpStatus status = HttpStatus.CONFLICT;

    public WrongPassword(String message) {
        super(message);
    }
}
