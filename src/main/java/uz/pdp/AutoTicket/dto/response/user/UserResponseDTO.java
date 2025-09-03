package uz.pdp.AutoTicket.dto.response.user;

import java.util.List;

import uz.pdp.AutoTicket.dto.marker.Response;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String phoneNumber,
        List<String> roles
) implements Response {
}
