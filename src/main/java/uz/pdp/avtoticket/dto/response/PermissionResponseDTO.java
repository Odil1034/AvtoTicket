package uz.pdp.avtoticket.dto.response;

import uz.pdp.avtoticket.dto.marker.Response;

public record PermissionResponseDTO(
        Long id,
        String name
) implements Response {

}
