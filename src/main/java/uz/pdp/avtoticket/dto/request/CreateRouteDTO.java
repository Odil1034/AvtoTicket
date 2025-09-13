package uz.pdp.avtoticket.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.response.AddressResponseDTO;

public record CreateRouteDTO(
        AddressResponseDTO fromAddress,
        AddressResponseDTO toAddress,
        @NotNull Double distance,
        LocalTime estimateTime
) implements Request {
}
