package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.request.create.CreateTicketDTO;
import uz.pdp.AvtoTicket.dto.response.TicketDTO;
import uz.pdp.AvtoTicket.dto.request.update.TicketUpdateDTO;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toEntity(CreateTicketDTO dto);

//    Ticket toEntity(TicketDTO dto);

    TicketDTO toDTO(Ticket ticket);

    List<TicketDTO> toDTOList(List<Ticket> ticket);

    void toUpdate(@MappingTarget Ticket ticket, TicketUpdateDTO dto);

}
