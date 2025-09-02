package uz.pdp.AutoTicket.dto.response;

import java.time.LocalDateTime;

import uz.pdp.AutoTicket.dto.marker.Response;

public record TicketResponseDTO(
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
