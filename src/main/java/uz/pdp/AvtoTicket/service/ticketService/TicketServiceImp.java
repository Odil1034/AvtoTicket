package uz.pdp.AvtoTicket.service.ticketService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.CreateTicketDTO;
import uz.pdp.AvtoTicket.dto.response.TicketDTO;
import uz.pdp.AvtoTicket.dto.request.update.TicketUpdateDTO;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.TicketMapper;
import uz.pdp.AvtoTicket.repository.TicketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {

    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;

    @Override
    public TicketDTO create(CreateTicketDTO dto) {
        Ticket entity = ticketMapper.toEntity(dto);
        Ticket save = ticketRepository.save(entity);
        return ticketMapper.toDTO(save);
    }

    @Override
    public TicketDTO getById(Long id) {
        Ticket byId = findById(id);
        return ticketMapper.toDTO(byId);
    }

    @Override
    public List<TicketDTO> getAll() {
        List<Ticket> all = ticketRepository.findAll();
        return ticketMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Ticket byId = findById(id);
        byId.setDeleted(true);
        ticketRepository.save(byId);
        return true;
    }

    @Override
    public TicketDTO update(Long ticketId, TicketUpdateDTO dto) {
        Ticket byId = findById(ticketId);
        ticketMapper.toUpdate(byId, dto);
        Ticket save = ticketRepository.save(byId);
        return ticketMapper.toDTO(save);
    }

    @Override
    public Ticket findById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket not found with id : " + id));
        if (!ticket.isDeleted()) {
            return ticket;
        } else {
            throw new IsDeletedException("Ticket is deleted with id = " + id);
        }
    }
}
