package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateSeatDTO;
import uz.pdp.AutoTicket.dto.request.UpdateSeatDTO;
import uz.pdp.AutoTicket.dto.response.SeatResponseDTO;
import uz.pdp.AutoTicket.entity.Seat;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:57
 */
public interface SeatService extends GenericCruidService<Long, Seat, SeatResponseDTO, CreateSeatDTO, UpdateSeatDTO> {
}
