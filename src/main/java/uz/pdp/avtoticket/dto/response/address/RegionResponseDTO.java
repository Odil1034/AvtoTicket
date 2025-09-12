package uz.pdp.avtoticket.dto.response.address;

import uz.pdp.avtoticket.dto.marker.Response;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:35
 */
public record RegionResponseDTO(
        Long id,
        Long soatoId,
        Long countryId,
        String nameUz,
        String nameRu,
        String nameOz
) implements Response {
}
