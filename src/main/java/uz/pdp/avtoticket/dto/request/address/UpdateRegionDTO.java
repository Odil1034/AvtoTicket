package uz.pdp.avtoticket.dto.request.address;

import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:31
 */
public record UpdateRegionDTO(
        Long id,
        String nameUz,
        String nameRu,
        String nameCy
) implements Request {

}
