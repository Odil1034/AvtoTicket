package uz.pdp.AvtoTicket.dto.route;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.address.Address;

import java.time.LocalTime;

public record CreateRouteDTO(
        Address fromAddress,
        Address toAddress,
        Double distance,
        LocalTime estimateTime
) implements BaseDTO {
}
