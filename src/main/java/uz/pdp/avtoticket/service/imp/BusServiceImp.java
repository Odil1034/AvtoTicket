package uz.pdp.avtoticket.service.imp;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.bus.BusCreateDTO;
import uz.pdp.avtoticket.dto.request.bus.BusUpdateDTO;
import uz.pdp.avtoticket.dto.response.BusModelResponseDTO;
import uz.pdp.avtoticket.dto.response.SeatResponseDTO;
import uz.pdp.avtoticket.dto.response.TripResponseDTO;
import uz.pdp.avtoticket.dto.response.bus.BusResponseDTO;
import uz.pdp.avtoticket.entity.Bus;
import uz.pdp.avtoticket.enums.BusStatus;
import uz.pdp.avtoticket.mapper.BusMapper;
import uz.pdp.avtoticket.repository.BusRepository;
import uz.pdp.avtoticket.service.BusService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 09/09/2025 07:31
 */
public class BusServiceImp extends AbstractService<BusRepository, BusMapper> implements BusService {

    public BusServiceImp(BusRepository repository, BusMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<Boolean> assignDriver(Long busId, Long driverId) {
        return null;
    }

    @Override
    public Response<BusResponseDTO> releaseDriver(Long busId) {
        return null;
    }

    @Override
    public Response<List<TripResponseDTO>> getBusTrips(Long busId) {
        return null;
    }

    @Override
    public Response<List<SeatResponseDTO>> getAvailableSeats(Long busId, LocalDate date) {
        return null;
    }

    @Override
    public Response<Boolean> updateBusModelStatus(Long modelId, BusStatus status) {
        return null;
    }

    @Override
    public Response<Integer> getBusCountByModelId(Long modelId) {
        return null;
    }

    @Override
    public Response<List<BusModelResponseDTO>> getModelsBySeatCount(int seatCount) {
        return null;
    }

    @Override
    public Response<BusResponseDTO> create(BusCreateDTO dto) {
        Bus bus = mapper.fromCreate(dto);

        return null;
    }

    @Override
    public Response<BusResponseDTO> update(BusUpdateDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<BusResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<BusResponseDTO>> findAll() {
        return null;
    }
}
