package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.response.AddressResponseDTO;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 14:25
 */
public record CreateTripDTO(
        Long busId,
        AddressResponseDTO fromAddress,
        AddressResponseDTO toAddress,
        Double distance,
        Integer countOfSeats,
        Double price
) implements Request {
}
