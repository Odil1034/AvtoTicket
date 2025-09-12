package uz.pdp.avtoticket.dto.request.address;

import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:30
 */
public record CreateAddressDTO(
        Long districtId,
        Double latitude,
        Double longitude
) implements Request {
}
