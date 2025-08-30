package uz.pdp.AvtoTicket.dto.user;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.BaseDTO;

import java.time.LocalDate;

public record UserCreateDTO(
        @NotNull String username,
        @NotNull String password,
        @NotNull String firstName,
        @NotNull String lastName,
        LocalDate dateOfBirth,
        String passportNumber,
        @NotNull String email,
        @NotNull String phoneNumber,
        String gender
//        Image profileImage,
//        List<Bus>buses
//        List<Order>orders
//        List<Ticket>tickets
//        List<Card>cards
//        Set<Role>roles
) implements BaseDTO {
}
