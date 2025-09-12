package uz.pdp.avtoticket.dto.request;

import java.util.List;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.response.ticket.TicketResponseDTO;

public record CreateOrderDTO(
        List<TicketResponseDTO> tickets
    ) implements Request {

}
