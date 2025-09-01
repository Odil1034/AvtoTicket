package uz.pdp.AutoTicket.dto.role;

import java.util.List;

import uz.pdp.AutoTicket.dto.marker.DTO;
import uz.pdp.AutoTicket.dto.marker.Response;

public record RoleResponseDTO(
        Long id,
        String name,
        List<String> permissions
) implements Response {

}
