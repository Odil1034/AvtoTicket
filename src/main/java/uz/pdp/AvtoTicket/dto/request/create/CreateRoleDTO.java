package uz.pdp.AvtoTicket.dto.request.create;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record CreateRoleDTO(
        String name,
        String description,
        List<Long> permissionIds
) implements BaseDTO {
}
