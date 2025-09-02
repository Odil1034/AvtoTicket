package uz.pdp.AutoTicket.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

public record CreateAddressDTO(
    @NotBlank @NotNull String region,
    @NotBlank @NotNull String city,
    @NotBlank @NotNull String district,
    Double latitude,
    Double longitude
) implements Request {

}
