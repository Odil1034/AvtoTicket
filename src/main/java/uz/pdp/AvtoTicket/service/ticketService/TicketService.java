package uz.pdp.AvtoTicket.service.ticketService;

import uz.pdp.AvtoTicket.dto.request.create.CreateTicketDTO;
import uz.pdp.AvtoTicket.dto.response.TicketDTO;
import uz.pdp.AvtoTicket.dto.request.update.TicketUpdateDTO;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;
import uz.pdp.AvtoTicket.service.BaseService;

public interface TicketService extends BaseService<Ticket, CreateTicketDTO, TicketUpdateDTO, TicketDTO> {

}
