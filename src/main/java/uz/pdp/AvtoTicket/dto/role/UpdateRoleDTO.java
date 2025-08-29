package uz.pdp.AvtoTicket.dto.role;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record UpdateRoleDTO(
        String name,
        String description,
        List<Long> permissionIds
) implements BaseDTO {
}
