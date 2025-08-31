package uz.pdp.AvtoTicket.dto.permission;

import uz.pdp.AvtoTicket.dto.marker.Request;

public record UpdatePermissionDTO(
        Long id,
        String name,
        String description
) implements Request {
}
