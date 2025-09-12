package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;

public record UpdatePermissionDTO(
        String access
) implements Request {
}
