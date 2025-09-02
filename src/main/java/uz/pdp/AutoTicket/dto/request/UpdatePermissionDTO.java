package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdatePermissionDTO(
        Long id,
        String name,
        String description
) implements Request {
}
