package uz.pdp.avtoticket.dto.response.address;

import uz.pdp.avtoticket.dto.marker.Response;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:13
 */
public record DistrictResponseDTO(
        Long id,
        Long soatoId,
        RegionResponseDTO region,
        String nameUz,
        String nameOz,
        String nameRu
) implements Response {
}
