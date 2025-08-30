package uz.pdp.AvtoTicket.dto.request.create;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CreateCardDTO(
        String holderName,
        String cardNumber,
        String expiredDate
)
        implements BaseDTO {
}
