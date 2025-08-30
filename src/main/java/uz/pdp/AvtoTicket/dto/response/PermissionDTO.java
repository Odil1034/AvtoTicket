package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record PermissionDTO(
        Long id,
        String name,
        String action,
        String entity,
        String description
) implements BaseDTO {

}
