package uz.pdp.AutoTicket.dto;

import java.util.List;

import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.entity.Ticket;

public record CreateOrderDTO(
        List<Ticket> tickets
    ) implements Request {

}
