package uz.pdp.avtoticket.dto.response.address;

import uz.pdp.avtoticket.dto.marker.Response;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:22
 */
public record CountryResponseDTO(
        Long id,
        String name
) implements Response {

}
