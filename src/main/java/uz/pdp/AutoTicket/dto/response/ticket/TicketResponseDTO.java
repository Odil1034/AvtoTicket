package uz.pdp.AutoTicket.dto.response.ticket;

import uz.pdp.AutoTicket.dto.marker.Response;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:00
 */
public record TicketResponseDTO(
        Long id,
        String passengerName,
        LocalDateTime bookingTime,
        Double price,
        String routeName,
        Long routeId,
        int seatNumber
) implements Response {

}
