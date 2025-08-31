package uz.pdp.AvtoTicket.dto.user;

import uz.pdp.AvtoTicket.dto.marker.DTO;

import java.time.LocalDate;

public record UserCreateDTO(
        String username,
        String password,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String passportNumber,
        String email,
        String phoneNumber,
        String gender
//        Image profileImage,
//        List<Bus>buses
//        List<Order>orders
//        List<Ticket>tickets
//        List<Card>cards
//        Set<Role>roles
) implements DTO {
}
