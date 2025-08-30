package uz.pdp.AvtoTicket.service.ticketService;

import uz.pdp.AvtoTicket.dto.ticket.CreateTicketDTO;
import uz.pdp.AvtoTicket.dto.ticket.TicketResponseDTO;
import uz.pdp.AvtoTicket.dto.ticket.TicketUpdateDTO;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;
import uz.pdp.AvtoTicket.service.BaseService;

public interface TicketService extends BaseService<Ticket, CreateTicketDTO, TicketUpdateDTO, TicketResponseDTO> {

}
