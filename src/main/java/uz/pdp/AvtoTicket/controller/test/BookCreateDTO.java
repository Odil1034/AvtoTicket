package uz.pdp.AvtoTicket.controller.test;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record BookCreateDTO(
        String title,
        String author,
        int countOfPage
) implements BaseDTO {

}
