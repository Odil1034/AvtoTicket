package uz.pdp.AvtoTicket.dto.card;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CreateCardDTO(
        String holderName,
        String cardNumber,
        String expiredDate
)
        implements BaseDTO {
}
