package uz.pdp.AvtoTicket.dto.request.update;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record UpdateRoleDTO(
        String name,
        String description,
        List<Long> permissionIds
) implements BaseDTO {
}
