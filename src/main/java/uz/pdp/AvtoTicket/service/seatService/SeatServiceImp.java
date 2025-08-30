package uz.pdp.AvtoTicket.service.seatService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.CreateSeatDTO;
import uz.pdp.AvtoTicket.dto.response.SeatDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateSeatDTO;
import uz.pdp.AvtoTicket.entity.seat.Seat;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.SeatMapper;
import uz.pdp.AvtoTicket.repository.SeatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImp implements SeatService {
    private final SeatMapper seatMapper;
    private final SeatRepository seatRepository;

    @Override
    public SeatDTO create(CreateSeatDTO dto) {
        Seat entity = seatMapper.toEntity(dto);
        Seat save = seatRepository.save(entity);
        return seatMapper.toDTO(save);
    }

    @Override
    public SeatDTO getById(Long id) {
        Seat byId = findById(id);
        return seatMapper.toDTO(byId);
    }

    @Override
    public List<SeatDTO> getAll() {
        List<Seat> all = seatRepository.findAll();
        return seatMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Seat byId = findById(id);
        byId.setDeleted(true);
        seatRepository.save(byId);
        return true;
    }

    @Override
    public SeatDTO update(Long seatId, UpdateSeatDTO dto) {
        Seat byId = findById(seatId);
        seatMapper.toUpdate(byId, dto);
        Seat save = seatRepository.save(byId);
        return seatMapper.toDTO(save);
    }

    @Override
    public Seat findById(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new NotFoundException("Seat not found with id : " + seatId));
        if (!seat.isDeleted()) {
            return seat;
        } else {
            throw new IsDeletedException("Seat is deleted with id = " + seatId);
        }
    }
}
