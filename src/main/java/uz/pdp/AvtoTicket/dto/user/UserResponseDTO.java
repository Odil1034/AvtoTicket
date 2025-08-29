package uz.pdp.AvtoTicket.dto.user;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.dto.role.RoleResponseDTO;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String phoneNumber,
        List<RoleResponseDTO> roles
) implements BaseDTO {
}
