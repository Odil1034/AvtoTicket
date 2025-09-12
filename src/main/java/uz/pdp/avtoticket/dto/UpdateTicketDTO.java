package uz.pdp.avtoticket.dto;

import uz.pdp.avtoticket.dto.marker.Request;

public record UpdateTicketDTO(
    String passengerName,
    Double price,
    Long tripId,
    Integer seatNumber
) implements Request {

}
