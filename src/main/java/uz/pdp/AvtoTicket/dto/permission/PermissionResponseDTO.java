package uz.pdp.AvtoTicket.dto.permission;

import uz.pdp.AvtoTicket.dto.marker.Response;

public record PermissionResponseDTO(
        Long id,
        String name,
        String description
) implements Response {

}
