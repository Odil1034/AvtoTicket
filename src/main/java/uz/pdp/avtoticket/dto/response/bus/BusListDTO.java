package uz.pdp.avtoticket.dto.response.bus;

import com.fasterxml.jackson.annotation.JsonInclude;
import uz.pdp.avtoticket.dto.marker.Response;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:38
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BusListDTO(
        Long id,
        String modelName,
        String plateNumber,
        Integer countOfSeats
) implements Response {
}
