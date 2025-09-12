package uz.pdp.avtoticket.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;

public record CreateRoleDTO(
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String description,
        List<CreatePermissionDTO> permissions
) implements Request {
}
