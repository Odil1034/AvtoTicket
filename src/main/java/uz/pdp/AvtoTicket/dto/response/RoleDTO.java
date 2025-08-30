package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.util.List;

public record RoleDTO(
        Long id,
        String name,
        List<PermissionDTO> permissions
) implements BaseDTO {

}
