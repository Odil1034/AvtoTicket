package uz.pdp.avtoticket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateSeatDTO;
import uz.pdp.avtoticket.dto.request.UpdateSeatDTO;
import uz.pdp.avtoticket.dto.response.SeatResponseDTO;
import uz.pdp.avtoticket.mapper.SeatMapper;
import uz.pdp.avtoticket.repository.SeatRepository;
import uz.pdp.avtoticket.service.SeatService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:57
 */
@Service
public class SeatServiceImp extends AbstractService<SeatRepository, SeatMapper> implements SeatService {

    public SeatServiceImp(SeatRepository repository, SeatMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<List<SeatResponseDTO>> getSeatsByTripId(Long tripId) {
        return null;
    }

    @Override
    public Response<List<SeatResponseDTO>> getAvailableSeatsByTripId(Long tripId) {
        return null;
    }

    @Override
    public Response<List<SeatResponseDTO>> getSeatsByUserId(Long userId) {
        return null;
    }

    @Override
    public Response<List<SeatResponseDTO>> getSeatsByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Response<Boolean> reserveSeat(Long seatId, Long userId) {
        return null;
    }

    @Override
    public Response<Boolean> cancelSeatReservation(Long seatId) {
        return null;
    }

    @Override
    public Response<Boolean> isSeatAvailable(Long seatId) {
        return null;
    }

    @Override
    public Response<Integer> getBookedSeatCount(Long tripId) {
        return null;
    }

    @Override
    public Response<Integer> getAvailableSeatCount(Long tripId) {
        return null;
    }

    @Override
    public Response<SeatResponseDTO> create(CreateSeatDTO dto) {
        return null;
    }

    @Override
    public Response<SeatResponseDTO> update(UpdateSeatDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<SeatResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<SeatResponseDTO>> findAll() {
        return null;
    }
}
