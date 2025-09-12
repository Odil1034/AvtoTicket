package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 14:25
 */
public record CreateTripDTO(
        Long busId,
        CreateAddressDTO fromAddress,
        CreateAddressDTO toAddress,
        Double distance,
        Integer countOfSeats,
        Double price
) implements Request {
}
