package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.response.ticket.TicketDetailsDTO;
import uz.pdp.AutoTicket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.AutoTicket.entity.Ticket;
import uz.pdp.AutoTicket.service.markers.GenericQueryService;

public interface TicketService extends GenericQueryService<Long, Ticket, TicketResponseDTO> {

    Response<TicketDetailsDTO> getTicketDetails(Long id);

    // user chipta bron qiladi.
    Response<TicketResponseDTO> bookTicket(Long userId, Long routeId, int seatNumber);

    // user o‘z chiptasini bekor qiladi.
    Response<Boolean> cancelTicket(Long ticketId, Long userId);

    // foydalanuvchi barcha chiptalarini ko‘radi.
    Response<TicketResponseDTO> getUserTickets(Long userId);

    //  conductor yoki driver chipta haqiqiymi tekshiradi.
    Response<Boolean> validateTicket(Long ticketId);

    // chipta boshqa userga o‘tkaziladi (ixtiyoriy).
    Response<Boolean> transferTicket(Long ticketId, Long toUserId);
}