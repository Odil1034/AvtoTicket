package uz.pdp.AutoTicket.dto.request;

import java.time.LocalDate;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UserUpdateDTO(
        String username,
        String password,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String passportNumber,
        String email,
        String phoneNumber,
        String gender
//        Documents profileImage,
//        List<Bus>buses
//        List<Order>orders
//        List<Ticket>tickets
//        List<Card>cards
//        Set<Role>roles
) implements Request {
}
