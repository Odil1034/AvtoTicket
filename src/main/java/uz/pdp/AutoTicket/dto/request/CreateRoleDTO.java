package uz.pdp.AutoTicket.dto.request;

import java.util.List;

import uz.pdp.AutoTicket.dto.marker.Request;

public record CreateRoleDTO(
        String name,
        String description,
        List<CreatePermissionDTO> permissions
) implements Request {
}
