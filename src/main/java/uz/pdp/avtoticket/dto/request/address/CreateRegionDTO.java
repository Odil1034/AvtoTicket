package uz.pdp.avtoticket.dto.request.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:29
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateRegionDTO(
        Long soatoId,
        Long countryId,
        String nameUz,
        String nameOz,
        String nameRu
) implements Request {
}