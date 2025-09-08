package uz.pdp.AutoTicket.dto.response;

import java.util.Set;

import uz.pdp.AutoTicket.dto.marker.Response;

public record RoleResponseDTO(
        Long id,
        String name,
        Set<PermissionResponseDTO> permissions
) implements Response {
}
