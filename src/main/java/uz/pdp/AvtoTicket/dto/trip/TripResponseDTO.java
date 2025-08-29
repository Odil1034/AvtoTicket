package uz.pdp.AvtoTicket.dto.trip;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.route.Route;

import java.time.LocalDateTime;

public record TripResponseDTO(
        Long tripId,
        Route route,
        LocalDateTime departure,
        LocalDateTime arrival,
        int countOfSeats,
        boolean isActive,
        Double price
) implements BaseDTO {
}
