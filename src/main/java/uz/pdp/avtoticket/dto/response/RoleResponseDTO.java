package uz.pdp.avtoticket.dto.response;

import java.util.Set;

import uz.pdp.avtoticket.dto.marker.Response;

public record RoleResponseDTO(
        Long id,
        String name,
        Set<PermissionResponseDTO> permissions
) implements Response {
}
