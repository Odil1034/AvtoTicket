package uz.pdp.AvtoTicket.dto.permission;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record UpdatePermissionDTO(
        Long id,
        String name,
        String description
) implements BaseDTO {
}
