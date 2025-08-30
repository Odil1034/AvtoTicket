package uz.pdp.AvtoTicket.service.seatService;

import uz.pdp.AvtoTicket.dto.seat.CreateSeatDTO;
import uz.pdp.AvtoTicket.dto.seat.SeatResponseDTO;
import uz.pdp.AvtoTicket.dto.seat.UpdateSeatDTO;
import uz.pdp.AvtoTicket.entity.seat.Seat;
import uz.pdp.AvtoTicket.service.BaseService;

public interface SeatService extends BaseService<Seat, CreateSeatDTO, UpdateSeatDTO, SeatResponseDTO> {
}
