package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record CreateTicketDTO(
    String passengerName,
    Double price,
    Long tripId,
    Integer seatNumber
) implements Request {
}
