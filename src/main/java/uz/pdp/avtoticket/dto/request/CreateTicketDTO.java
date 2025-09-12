package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;

public record CreateTicketDTO(
    String passengerName,
    Double price,
    Long tripId,
    Integer seatNumber
) implements Request {
}
