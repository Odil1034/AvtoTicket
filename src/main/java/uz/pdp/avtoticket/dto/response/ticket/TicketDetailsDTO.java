package uz.pdp.avtoticket.dto.response.ticket;

import java.time.LocalDateTime;

import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.dto.response.RouteResponseDTO;

public record TicketDetailsDTO(
        Long id,
        String passengerName,
        LocalDateTime bookingTime,
        Double price,
        Long tripId,
        RouteResponseDTO route,
        Integer seatNumber,
        Long ownerId,
        Long orderId
) implements Response {

}
