package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.response.ticket.TicketDetailsDTO;
import uz.pdp.avtoticket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.avtoticket.entity.Ticket;
import uz.pdp.avtoticket.service.markers.GenericQueryService;

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