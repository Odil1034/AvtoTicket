package uz.pdp.AvtoTicket.dto.card;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CardResponseDTO(
        Long id,
        Long ownerId,
        String holderName,
        String cardNumber,
        String expiredDate
) implements BaseDTO {
}
