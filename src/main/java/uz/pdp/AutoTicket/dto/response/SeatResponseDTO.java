package uz.pdp.AutoTicket.dto.response;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.enums.SeatStatus;
import uz.pdp.AutoTicket.enums.SeatType;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:58
 */
public record SeatResponseDTO(
        @NotNull Integer seatNumber,
        SeatType type,
        SeatStatus status,
        Long busId
) implements Response {
}
