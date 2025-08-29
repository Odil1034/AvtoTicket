package uz.pdp.AvtoTicket.dto.permission;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.enums.permission.Action;
import uz.pdp.AvtoTicket.enums.permission.EntityType;

public record PermissionResponseDTO(
        Long id,
        String name,
        Action action,
        EntityType entity,
        String description
) implements BaseDTO {

}
