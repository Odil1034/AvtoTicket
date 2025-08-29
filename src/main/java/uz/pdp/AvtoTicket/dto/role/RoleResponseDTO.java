package uz.pdp.AvtoTicket.dto.role;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record RoleResponseDTO(
        Long id,
        String name,
        List<String> permissions
) implements BaseDTO {

}
