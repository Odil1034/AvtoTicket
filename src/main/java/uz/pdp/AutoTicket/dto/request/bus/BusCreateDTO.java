package uz.pdp.AutoTicket.dto.request.bus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:46
 */
public record BusCreateDTO(
        @NotNull @NotBlank String manufacturer,
        @NotNull @NotBlank String modelName,
        @NotNull @NotBlank String plateNumber,
        @NotNull @NotBlank Integer countOfSeats
) implements Request {
}