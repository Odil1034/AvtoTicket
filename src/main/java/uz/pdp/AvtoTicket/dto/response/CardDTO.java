package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CardDTO(
        Long id,
        Long ownerId,
        String holderName,
        String cardNumber,
        String expiredDate
) implements BaseDTO {
}
