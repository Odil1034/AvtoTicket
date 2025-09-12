package uz.pdp.avtoticket.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;

public record CreateRouteDTO(
        CreateDistrictDTO fromAddress,
        CreateDistrictDTO toAddress,
        @NotNull Double distance,
        LocalTime estimateTime
) implements Request {
}
