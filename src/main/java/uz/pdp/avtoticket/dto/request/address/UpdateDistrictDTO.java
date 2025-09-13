package uz.pdp.avtoticket.dto.request.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 15:08
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateDistrictDTO(
        Long id,
        @NotBlank String nameUz,
        @NotBlank String nameRu,
        @NotBlank String nameOz
) implements Request {
}
