package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdatePermissionDTO(
        String access
) implements Request {
}
