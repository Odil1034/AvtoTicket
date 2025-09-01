package uz.pdp.AutoTicket.dto.role;

import java.util.List;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdateRoleDTO(
        String name,
        String description,
        List<Long> permissionIds
) implements Request {
}
