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
@JsonPropertyOrder({"soato_id", "district_id", "name_uz", "name_oz", "name_ru"})
public record CreateRegionDTO(
        @JsonProperty("soato_id")
        Long soatoId,
        @JsonProperty("country_id")
        Long countryId,
        @JsonProperty("district_id")
        Long districtId,
        @JsonProperty("name_uz")
        String nameUz,
        @JsonProperty("name_ru")
        String nameRu,
        @JsonProperty("name_oz")
        String nameOz
) implements Request {
}