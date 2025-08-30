package uz.pdp.AvtoTicket.dto.permission;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record CreatePermissionDTO(
        String name,
        String description
) implements BaseDTO {
}
