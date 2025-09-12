package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.response.SeatResponseDTO;
import uz.pdp.avtoticket.enums.TripStatus;

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
