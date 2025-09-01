package uz.pdp.AutoTicket.dto.permission;

import uz.pdp.AutoTicket.dto.marker.Request;

public record CreatePermissionDTO(
        String name,
        String description
) implements Request {
}
