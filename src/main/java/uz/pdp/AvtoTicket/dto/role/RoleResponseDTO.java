package uz.pdp.AvtoTicket.dto.role;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.dto.permission.PermissionResponseDTO;

import java.util.List;

public record RoleResponseDTO(
        Long id,
        String name,
        List<PermissionResponseDTO> permissions
) implements BaseDTO {

}
