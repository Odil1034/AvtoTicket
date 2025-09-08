package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UserCreateDTO(
        String username,
        String password,
        String email,
        String phoneNumber
) implements Request {
}
