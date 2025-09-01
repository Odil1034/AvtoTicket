package uz.pdp.AutoTicket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Data is deleted")
public class NotFoundException extends RuntimeException {

    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundException(String message) {
        super(message);
    }
}
