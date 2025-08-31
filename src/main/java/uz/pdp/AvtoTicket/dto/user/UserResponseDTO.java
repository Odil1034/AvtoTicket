package uz.pdp.AvtoTicket.dto.user;

import uz.pdp.AvtoTicket.dto.marker.DTO;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String phoneNumber,
        List<String> roles
) implements DTO {
}
