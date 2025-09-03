package uz.pdp.AutoTicket.dto.response;

import uz.pdp.AutoTicket.dto.marker.Response;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:00
 */
public record TicketListDTO(
        Long id,
        String passengerName,
        LocalDateTime bookingTime,
        Double price,
        Long tripId,
        RouteResponseDTO route,
        int seatNumber
) implements Response {
}
