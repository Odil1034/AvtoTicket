package uz.pdp.AutoTicket.dto.request.bus;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:50
 */
public record BusUpdateDTO(
        @NotNull Long id,
        @NotNull String manufacturer,
        @NotNull String modelName,
        Integer standingCapacity,
        String description,
        String plateNumber
) implements Request {
}
