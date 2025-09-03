package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

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
