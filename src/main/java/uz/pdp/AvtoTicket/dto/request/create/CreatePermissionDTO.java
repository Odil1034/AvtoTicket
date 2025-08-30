package uz.pdp.AvtoTicket.dto.request.create;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CreatePermissionDTO(
        String name,
        String description
) implements BaseDTO {
}
