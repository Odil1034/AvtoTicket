package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;

public record CreatePermissionDTO(
        String access
) implements Request {
}
