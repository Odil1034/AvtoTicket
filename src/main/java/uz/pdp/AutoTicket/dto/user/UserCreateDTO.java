package uz.pdp.AutoTicket.dto.user;

import java.time.LocalDate;

import uz.pdp.AutoTicket.dto.marker.Request;

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
) implements Request {
}
