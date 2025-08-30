package uz.pdp.AvtoTicket.dto.request.update;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.enums.FuelType;
import uz.pdp.AvtoTicket.enums.ModelType;

public record BusUpdateDTO(
        Long id,
        @NotNull ModelType modelName,
        @NotNull String manufacturer,
        @NotNull int countOfSeats,
        FuelType fuelType,
        int standingCapacity,
        String description,
        @NotNull String plateNumber
) implements BaseDTO {
}