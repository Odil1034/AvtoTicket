package uz.pdp.AvtoTicket.dto.permission;

import uz.pdp.AvtoTicket.dto.marker.Request;

public record CreatePermissionDTO(
        String name,
        String description
) implements Request {
}
