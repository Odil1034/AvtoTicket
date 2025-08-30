package uz.pdp.AvtoTicket.controller.test;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record BookResponseDTO(
        Long bookId,
        String title,
        String author,
        int countOfPage
) implements BaseDTO {
}
