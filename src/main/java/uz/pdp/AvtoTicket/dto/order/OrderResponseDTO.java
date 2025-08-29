package uz.pdp.AvtoTicket.dto.order;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.dto.ticket.TicketResponseDTO;
import uz.pdp.AvtoTicket.enums.PaymentStatus;

import java.util.List;

public record OrderResponseDTO(
        Long orderId,
        Long userId,
        Double totalPrice,
        PaymentStatus status,
        List<TicketResponseDTO> tickets
) implements BaseDTO {

}
