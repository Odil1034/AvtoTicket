package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;

public record UserCreateDTO(
        String username,
        String password
) implements Request {
}
