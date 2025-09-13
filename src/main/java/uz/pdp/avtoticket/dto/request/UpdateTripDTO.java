package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.UpdateTicketDTO;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.TripStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 15:07
 */
public record UpdateTripDTO(
        Long id,
        Long routeId,
        Long busId,

        LocalDateTime departure,
        LocalDateTime arrival,
        String tripName,
        TripStatus tripStatus,
        List<UpdateSeatDTO> seats,
        List<UpdateTicketDTO> tickets
) implements Request {

}
