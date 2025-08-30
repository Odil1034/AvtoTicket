package uz.pdp.AvtoTicket.dto.request.create;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CreateAddressDTO(
        @NotNull String region,
        @NotNull String city,
        @NotNull String district,

        Double longitude,   // optional
        Double latitude
) implements BaseDTO {

}
