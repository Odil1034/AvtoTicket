package uz.pdp.avtoticket.dto.request.bus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.request.CreateBusModelDTO;
import uz.pdp.avtoticket.enums.FuelType;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:46
 */
public record BusCreateDTO(
        @NotNull @NotBlank CreateBusModelDTO modelName,
        @NotNull @NotBlank String plateNumber,
        @NotNull @NotBlank Integer countOfSeats,
        @NotNull FuelType fuelType,
        String description
) implements Request {
}