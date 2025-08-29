package uz.pdp.AvtoTicket.dto.card;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record UpdateCardDTO(
        Long cardId,
        String holderName,
        String cardNumber,
        String expiredDate
) implements BaseDTO {
}
