package uz.pdp.AvtoTicket.dto.route;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.dto.address.AddressData;

import java.time.LocalTime;

public record RouteResponseDTO(
        Long id,
        AddressData fromAddress,
        AddressData toAddress,
        Double distance,
        LocalTime estimateTime
) implements BaseDTO {
}
