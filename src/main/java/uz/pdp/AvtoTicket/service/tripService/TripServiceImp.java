package uz.pdp.AvtoTicket.service.tripService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.CreateTripDTO;
import uz.pdp.AvtoTicket.dto.response.TripDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateTripDTO;
import uz.pdp.AvtoTicket.entity.trip.Trip;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.TripMapper;
import uz.pdp.AvtoTicket.repository.TripRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImp implements TripService {
    private final TripMapper tripMapper;
    private final TripRepository tripRepository;

    @Override
    public TripDTO create(CreateTripDTO dto) {
        Trip entity = tripMapper.toEntity(dto);
        Trip save = tripRepository.save(entity);
        return tripMapper.toDTO(save);
    }

    @Override
    public TripDTO getById(Long id) {
        Trip byId = findById(id);
        return tripMapper.toDTO(byId);
    }

    @Override
    public List<TripDTO> getAll() {
        List<Trip> all = tripRepository.findAll();
        return tripMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Trip byId = findById(id);
        byId.setDeleted(true);
        tripRepository.save(byId);
        return true;
    }

    @Override
    public TripDTO update(Long tripId, UpdateTripDTO dto) {
        Trip byId = findById(tripId);
        tripMapper.toUpdate(byId, dto);
        Trip save = tripRepository.save(byId);
        return tripMapper.toDTO(save);
    }

    @Override
    public Trip findById(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new NotFoundException("Trip not found with id : " + tripId));
        if (!trip.isDeleted()) {
            return trip;
        } else {
            throw new IsDeletedException("Trip is deleted with id = " + tripId);
        }
    }
}
