package uz.pdp.AvtoTicket.dto.address;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.BaseDTO;

public record AddressResponseDTO(
        Long id,
        @NotNull
        String region,
        @NotNull
        String city,
        @NotNull
        String district,

        Double longitude,   // optional
        Double latitude
) implements BaseDTO {

}
