package uz.pdp.AvtoTicket.dto.request.update;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record UpdatePermissionDTO(
        Long id,
        String name,
        String description
) implements BaseDTO {
}
