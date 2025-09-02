package uz.pdp.AutoTicket.dto.response;

import uz.pdp.AutoTicket.dto.marker.Response;

public record PermissionResponseDTO(
        Long id,
        String name,
        String description
) implements Response {

}
