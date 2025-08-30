package uz.pdp.AvtoTicket.dto.request.update;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record UpdateCardDTO(
        Long cardId,
        String holderName,
        String cardNumber,
        String expiredDate
) implements BaseDTO {
}
