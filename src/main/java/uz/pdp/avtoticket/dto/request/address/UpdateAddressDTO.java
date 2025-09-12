package uz.pdp.avtoticket.dto.request.address;

import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:50
 */
public record UpdateAddressDTO(
        Long id,
        Long districtId,
        Double longitude,
        Double latitude
) implements Request {

}
