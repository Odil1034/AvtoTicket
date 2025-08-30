package uz.pdp.AvtoTicket.dto.request.create;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.enums.PaymentStatus;

public record OrderCreateDTO(
        Long ownerId,
        Double totalPrice,
        PaymentStatus status
) implements BaseDTO {
}
