package uz.pdp.AvtoTicket.service.busService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.BusCreateDTO;
import uz.pdp.AvtoTicket.dto.response.BusDTO;
import uz.pdp.AvtoTicket.dto.request.update.BusUpdateDTO;
import uz.pdp.AvtoTicket.entity.bus.Bus;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.BusMapper;
import uz.pdp.AvtoTicket.repository.BusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImp implements BusService {


    private final BusMapper busMapper;
    private final BusRepository busRepository;

    @Override
    public BusDTO create(BusCreateDTO dto) {
        Bus entity = busMapper.toEntity(dto);
        Bus save = busRepository.save(entity);
        return busMapper.toDTO(save);
    }

    @Override
    public BusDTO getById(Long id) {
        Bus byId = findById(id);
        return busMapper.toDTO(byId);
    }

    @Override
    public List<BusDTO> getAll() {
        List<Bus> all = busRepository.findAll();
        return busMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Bus byId = findById(id);
        byId.setDeleted(true);
        busRepository.save(byId);
        return true;
    }

    @Override
    public BusDTO update(Long busId, BusUpdateDTO dto) {
        Bus byId = findById(busId);
        busMapper.toUpdate(byId, dto);
        Bus save = busRepository.save(byId);
        return busMapper.toDTO(save);
    }

    @Override
    public Bus findById(Long busId) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new NotFoundException("Bus not found with id : " + busId));
        if (!bus.isDeleted()) {
            return bus;
        } else {
            throw new IsDeletedException("Bus is deleted with id = " + busId);
        }
    }
}
