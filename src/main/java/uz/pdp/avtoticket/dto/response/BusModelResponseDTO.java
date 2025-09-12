package uz.pdp.avtoticket.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.enums.BusModelStatus;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:10
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BusModelResponseDTO(
        Long id,
        String modelName,
        String manufacturer,
        BusModelStatus status
) implements Response {
}
