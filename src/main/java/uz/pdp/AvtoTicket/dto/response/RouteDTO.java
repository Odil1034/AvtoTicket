package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.time.LocalTime;

public record RouteDTO(
        Long id,
        AddressDTO fromAddress,
        AddressDTO toAddress,
        Double distance,
        LocalTime estimateTime
) implements BaseDTO {
}
