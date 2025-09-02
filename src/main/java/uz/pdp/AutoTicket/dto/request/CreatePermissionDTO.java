package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record CreatePermissionDTO(
        String access
) implements Request {
}
