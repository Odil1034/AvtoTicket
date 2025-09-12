package uz.pdp.avtoticket.dto.response;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.enums.SeatStatus;
import uz.pdp.avtoticket.enums.SeatType;

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
