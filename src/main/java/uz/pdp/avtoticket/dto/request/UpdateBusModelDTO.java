package uz.pdp.avtoticket.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.Manufacturer;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateBusModelDTO(
        Long id,
        @NotNull @NotBlank
        String model,
        Manufacturer manufacturer
) implements Request {

}
