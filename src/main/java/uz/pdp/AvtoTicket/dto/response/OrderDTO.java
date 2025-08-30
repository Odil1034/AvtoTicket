package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.enums.PaymentStatus;

import java.util.List;

public record OrderDTO(
        Long orderId,
        Long userId,
        Double totalPrice,
        PaymentStatus status,
        List<TicketDTO> tickets
) implements BaseDTO {

}
