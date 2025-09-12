package uz.pdp.avtoticket.dto.request;

import java.util.List;

import uz.pdp.avtoticket.dto.marker.Request;

public record UpdateRoleDTO(
        String name,
        String description,
        List<Long> permissionIds
) implements Request {
}
