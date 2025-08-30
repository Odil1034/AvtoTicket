package uz.pdp.AvtoTicket.dto.ticket;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.order.Order;
import uz.pdp.AvtoTicket.entity.trip.Trip;
import uz.pdp.AvtoTicket.entity.user.User;

import java.time.LocalDateTime;

public record TicketUpdateDTO(
        Long id,
        String passengerName,
        LocalDateTime bookingTime,
        Trip trip,
        int seatNumber,
        User owner,
        Order order
) implements BaseDTO {
}
