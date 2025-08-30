package uz.pdp.AvtoTicket.controller.test;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record BookUpdateDTO(
        String title,
        String author,
        int countOfPage
) implements BaseDTO {
}
