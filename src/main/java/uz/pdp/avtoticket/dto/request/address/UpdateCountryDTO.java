package uz.pdp.avtoticket.dto.request.address;

import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:26
 */
public record UpdateCountryDTO(
        Long id,
        String name
) implements Request {
}
