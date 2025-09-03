package uz.pdp.AutoTicket.dto.request;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.enums.SeatStatus;
import uz.pdp.AutoTicket.enums.SeatType;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:01
 */
public record CreateSeatDTO(
        @NotNull Integer seatNumber,
        SeatType type,
        SeatStatus status,
        Long busId
) implements Request {
}

