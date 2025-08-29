package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.ticket.CreateTicketDTO;
import uz.pdp.AvtoTicket.dto.ticket.TicketResponseDTO;
import uz.pdp.AvtoTicket.dto.ticket.TicketUpdateDTO;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toEntity(CreateTicketDTO dto);

    Ticket toEntity(TicketResponseDTO dto);

    TicketResponseDTO toDTO(Ticket ticket);

    List<TicketResponseDTO> toDTOList(List<Ticket> ticket);

    void toUpdate(@MappingTarget Ticket ticket, TicketUpdateDTO dto);

}
