package uz.pdp.AutoTicket.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.enums.Manufacturer;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateBusModelDTO(
        Long id,
        @NotNull(message = "ModelName can not be null") @NotBlank
        String modelName,
        Manufacturer manufacturer
) implements Request {
}

