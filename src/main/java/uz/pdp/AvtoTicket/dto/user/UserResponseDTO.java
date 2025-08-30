package uz.pdp.AvtoTicket.dto.user;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String phoneNumber,
        List<String> roles
) implements BaseDTO {
}
