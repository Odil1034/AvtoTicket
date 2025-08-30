package uz.pdp.AvtoTicket.service.seatService;

import uz.pdp.AvtoTicket.dto.request.create.CreateSeatDTO;
import uz.pdp.AvtoTicket.dto.response.SeatDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateSeatDTO;
import uz.pdp.AvtoTicket.entity.seat.Seat;
import uz.pdp.AvtoTicket.service.BaseService;

public interface SeatService extends BaseService<Seat, CreateSeatDTO, UpdateSeatDTO, SeatDTO> {
}
