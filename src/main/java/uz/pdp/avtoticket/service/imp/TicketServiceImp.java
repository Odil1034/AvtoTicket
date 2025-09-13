package uz.pdp.avtoticket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.response.ticket.TicketDetailsDTO;
import uz.pdp.avtoticket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.avtoticket.mapper.TicketMapper;
import uz.pdp.avtoticket.repository.TicketRepository;
import uz.pdp.avtoticket.service.TicketService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:55
 */
@Service
public class TicketServiceImp
        extends AbstractService<TicketRepository, TicketMapper> implements TicketService {
    public TicketServiceImp(TicketRepository repository, TicketMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<TicketDetailsDTO> getTicketDetails(Long id) {
        return null;
    }

    @Override
    public Response<TicketResponseDTO> bookTicket(Long userId, Long routeId, int seatNumber) {
        return null;
    }

    @Override
    public Response<Boolean> cancelTicket(Long ticketId, Long userId) {
        return null;
    }

    @Override
    public Response<TicketResponseDTO> getUserTickets(Long userId) {
        return null;
    }

    @Override
    public Response<Boolean> validateTicket(Long ticketId) {
        return null;
    }

    @Override
    public Response<Boolean> transferTicket(Long ticketId, Long toUserId) {
        return null;
    }

    @Override
    public Response<TicketResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<TicketResponseDTO>> findAll() {
        return null;
    }
}
