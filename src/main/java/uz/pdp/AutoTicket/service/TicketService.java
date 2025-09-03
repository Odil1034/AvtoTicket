package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.response.ticket.TicketDetailsDTO;
import uz.pdp.AutoTicket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.AutoTicket.entity.Ticket;
import uz.pdp.AutoTicket.service.markers.GenericQueryService;

public interface TicketService extends GenericQueryService<Long, Ticket, TicketResponseDTO> {

    Response<TicketDetailsDTO> getTicketDetails(Long id);

}