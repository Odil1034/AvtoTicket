package uz.pdp.AvtoTicket.dto.request.update;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.BaseDTO;

public record UpdateAddressDTO(
        Long addressId,
        @NotNull String region,
        @NotNull String city,
        @NotNull String district,

        Double longitude,   // optional
        Double latitude
) implements BaseDTO {
}
