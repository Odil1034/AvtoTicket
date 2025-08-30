package uz.pdp.AvtoTicket.dto.order;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;
import uz.pdp.AvtoTicket.enums.PaymentStatus;

import java.util.List;

public record OrderUpdateDTO(
        Long orderId,
        Long userId,
        Double totalPrice,
        PaymentStatus status,
        List<Ticket> tickets
) implements BaseDTO {

}
