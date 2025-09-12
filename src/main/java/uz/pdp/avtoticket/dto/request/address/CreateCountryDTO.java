package uz.pdp.avtoticket.dto.request.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 13:15
 */
public record CreateCountryDTO(
        @NotNull @NotBlank String name
) implements Request {

}
