package uz.pdp.avtoticket.dto.request.address;

import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 15:08
 */
public record UpdateDistrictDTO(
        Long id,
        String nameUz,
        String nameRu,
        String nameOz
) implements Request {
}
