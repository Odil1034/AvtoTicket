package uz.pdp.AvtoTicket.dto.response;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.enums.FuelType;
import uz.pdp.AvtoTicket.enums.ModelType;

public record BusDTO(
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
