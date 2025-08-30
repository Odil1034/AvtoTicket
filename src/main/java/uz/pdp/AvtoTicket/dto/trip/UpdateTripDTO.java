package uz.pdp.AvtoTicket.dto.trip;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.route.Route;

import java.time.LocalDateTime;

public record UpdateTripDTO(
        Long tripId,
        Route route,
        LocalDateTime departure,
        LocalDateTime arrival,
        Integer countOfSeats,
        boolean isActive,
        Double price
) implements BaseDTO {
}
