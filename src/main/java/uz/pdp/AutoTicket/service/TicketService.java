package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.UpdateTicketDTO;
import uz.pdp.AutoTicket.dto.request.CreateTicketDTO;
import uz.pdp.AutoTicket.dto.response.TicketResponseDTO;
import uz.pdp.AutoTicket.entity.Ticket;

public interface TicketService
        extends GenericCruidService<Long, Ticket, TicketResponseDTO, CreateTicketDTO, UpdateTicketDTO> {
}
