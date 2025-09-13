package uz.pdp.avtoticket.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.pdp.avtoticket.utils.ErrorCode;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Data is deleted")
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message, Object... args) {
        super(HttpStatus.NO_CONTENT, ErrorCode.RESOURCE_NOT_FOUND.name(), message, args);
    }
}
