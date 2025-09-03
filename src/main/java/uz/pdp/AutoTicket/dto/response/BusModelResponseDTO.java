package uz.pdp.AutoTicket.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.enums.Manufacturer;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:10
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BusModelResponseDTO(
        Long id,
        String modelName,
        Manufacturer manufacturer
) implements Response {
}
