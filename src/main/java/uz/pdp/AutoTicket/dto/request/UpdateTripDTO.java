package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.dto.response.SeatResponseDTO;
import uz.pdp.AutoTicket.enums.TripStatus;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 15:07
 */
public record UpdateTripDTO(
        Long tripId,
        String tripName,
        TripStatus tripStatus,
        List<SeatResponseDTO> emptySeats
) implements Request {
}
