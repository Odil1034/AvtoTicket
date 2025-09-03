package uz.pdp.AutoTicket.dto.response;

import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.dto.response.bus.BusListDTO;
import uz.pdp.AutoTicket.enums.TripStatus;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 14:48
 */
public record TripResponseDTO(
        Long id,
        String routeName,
        LocalDateTime departure,  // Ketish
        LocalDateTime arrival,      // Kelish
        Integer emptySeats,
        TripStatus tripStatus,
        Double price,
        BusListDTO busListDTO
) implements Response {
}
