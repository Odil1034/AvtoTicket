package uz.pdp.AutoTicket.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

public record CreateRouteDTO(
        CreateAddressDTO fromAddress,
        CreateAddressDTO toAddress,
        @NotNull Double distance,
        LocalTime estimateTime
) implements Request {
}
