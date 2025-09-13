package uz.pdp.avtoticket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateTripDTO;
import uz.pdp.avtoticket.dto.request.UpdateTripDTO;
import uz.pdp.avtoticket.dto.response.TripResponseDTO;
import uz.pdp.avtoticket.dto.response.user.UserResponseDTO;
import uz.pdp.avtoticket.entity.*;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.mapper.TripMapper;
import uz.pdp.avtoticket.repository.BusRepository;
import uz.pdp.avtoticket.repository.TripRepository;
import uz.pdp.avtoticket.repository.UserRepository;
import uz.pdp.avtoticket.repository.address.AddressRepository;
import uz.pdp.avtoticket.service.TripService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:53
 */
@Service
public class TripServiceImp extends AbstractService<TripRepository, TripMapper> implements TripService {

    private final UserRepository userRepository;
    private final BusRepository busRepository;
    private final AddressRepository addressRepository;

    public TripServiceImp(TripRepository repository, TripMapper mapper, UserRepository userRepository, BusRepository busRepository, AddressRepository addressRepository) {
        super(repository, mapper);
        this.userRepository = userRepository;
        this.busRepository = busRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<TripResponseDTO> getUpcomingTrips() {

        return List.of();
    }

    @Override
    public List<TripResponseDTO> getPastTrips() {
        return List.of();
    }

    @Override
    public boolean updateTripStatus(Long tripId, String status) {
        return false;
    }

    @Override
    public List<TripResponseDTO> getTripsByRoute(String fromCity, String toCity) {
        return List.of();
    }

    @Override
    public List<TripResponseDTO> getTripsByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<TripResponseDTO> getTripsByBusId(Long busId) {
        return List.of();
    }

    @Override
    public List<TripResponseDTO> getMostBookedTrips(int topN) {
        return List.of();
    }

    @Override
    public int getBookedTicketCount(Long tripId) {
        return 0;
    }

    @Override
    public void cancelTrips(List<Long> tripIds) {

    }

    @Override
    public Response<List<String>> getPassengerNamesByTripId(Long tripId) {
        Trip trip = repository.findByIdCustom(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id {}", tripId));
        Set<Ticket> tickets = trip.getTickets();

        List<String> passengerNames = new ArrayList<>();
        if (tickets == null || tickets.isEmpty()) {
            return Response.ok(HttpStatus.NOT_FOUND, passengerNames);
        } else {
            for (Ticket ticket : tickets) {
                passengerNames.add(ticket.getPassengerName());
            }
            return Response.ok(passengerNames);
        }
    }

    @Override
    public Response<TripResponseDTO> create(CreateTripDTO dto) {
        Bus bus = busRepository.findByIdCustom(dto.busId())
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with id {0}", dto.busId()));
        Trip trip = mapper.fromCreate(dto);
        Trip save = repository.save(trip);
        return Response.ok(mapper.toDto(save));
    }

    @Override
    public Response<TripResponseDTO> update(UpdateTripDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<TripResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<TripResponseDTO>> findAll() {
        return null;
    }
}
