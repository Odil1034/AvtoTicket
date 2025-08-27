package uz.pdp.AvtoTicket.dto.user;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record UserResponseDTO(
        Long id,
        String username,
        String password,
        String email,
        String phoneNumber
) implements BaseDTO {
}
