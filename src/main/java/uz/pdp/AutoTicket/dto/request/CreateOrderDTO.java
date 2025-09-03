package uz.pdp.AutoTicket.dto.request;

import java.util.List;

import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.dto.response.TicketResponseDTO;

public record CreateOrderDTO(
        List<TicketResponseDTO> tickets
    ) implements Request {

}
