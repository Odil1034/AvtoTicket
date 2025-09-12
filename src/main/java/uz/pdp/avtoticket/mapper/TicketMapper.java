package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.UpdateTicketDTO;
import uz.pdp.avtoticket.dto.request.CreateTicketDTO;
import uz.pdp.avtoticket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.avtoticket.entity.Ticket;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:56
 */
@Mapper(componentModel = "spring")
public interface TicketMapper extends GenericMapper<Ticket, TicketResponseDTO, CreateTicketDTO, UpdateTicketDTO> {
}
