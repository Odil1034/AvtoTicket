package uz.pdp.AvtoTicket.dto.request.create;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.bus.Bus;
import uz.pdp.AvtoTicket.enums.SeatStatus;
import uz.pdp.AvtoTicket.enums.SeatType;

public record CreateSeatDTO(
        Integer seatNumber,
        SeatType type,          // BUSINESS, STANDARD
        SeatStatus status,      //EMPTY, BUSY, REVERSED, SELECTED
        Bus bus
) implements BaseDTO {
}
