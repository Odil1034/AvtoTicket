package uz.pdp.avtoticket.dto.request;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.SeatStatus;
import uz.pdp.avtoticket.enums.SeatType;

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

