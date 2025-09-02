package uz.pdp.AutoTicket.dto;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdateTicketDTO(
    String passengerName,
    Double price,
    Long tripId,
    Integer seatNumber
) implements Request {

}
