package uz.pdp.avtoticket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateRouteDTO;
import uz.pdp.avtoticket.dto.request.UpdateRouteDTO;
import uz.pdp.avtoticket.dto.response.RouteResponseDTO;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.Route;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.mapper.RouteMapper;
import uz.pdp.avtoticket.repository.RouteRepository;
import uz.pdp.avtoticket.repository.address.AddressRepository;
import uz.pdp.avtoticket.service.RouteService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 22:26
 */

@Service
public class RouteServiceImp extends AbstractService<RouteRepository, RouteMapper> implements RouteService {

    private static final int EARTH_RADIUS_KM = 6371;
    private static final double AVERAGE_SPEED = 40.0; // km/h

    private final AddressRepository addressRepository;

    public RouteServiceImp(RouteRepository repository, RouteMapper mapper, AddressRepository addressRepository) {
        super(repository, mapper);
        this.addressRepository = addressRepository;
    }

    @Override
    public Response<List<RouteResponseDTO>> getAvailableRoutes(String from, String to, LocalDate date) {
        return null;
    }

    @Override
    public Response<RouteResponseDTO> assignBusToRoute(Long routeId, Long busId) {
        return null;
    }

    @Override
    public Response<LocalTime> calculateTravelTime(Long routeId) {
        return null;
    }

    @Override
    public Response<RouteResponseDTO> assignBusesToRoute(Long routeId, List<Long> busIds) {
        return null;
    }

    @Override
    public Response<Integer> getTripCountByRoute(Long routeId) {
        return null;
    }

    @Override
    public Response<Boolean> updateRouteStatus(Long routeId, String status) {
        return null;
    }

    @Override
    public Response<List<RouteResponseDTO>> getRoutesByDateAndTime(LocalDate date, LocalTime time) {
        return null;
    }

    @Override
    public Response<Boolean> cancelRoute(Long routeId) {
        return null;
    }

    @Override
    public Response<RouteResponseDTO> create(CreateRouteDTO dto) {
        Address toAddress = addressRepository.findByIdCustom(dto.toAddress().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id {0}", dto.toAddress().getId()));

        Address fromAddress = addressRepository.findByIdCustom(dto.fromAddress().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id {0}", dto.fromAddress().getId()));

        double distance = calculateDistance(fromAddress, toAddress);
        LocalTime estimateTime = calculateEstimateTime(distance);
        String routeName = generateRouteName(fromAddress, toAddress);

        Route newRoute = Route.builder()
                .toAddress(toAddress)
                .fromAddress(fromAddress)
                .distance(distance)
                .estimateTime(estimateTime)
                .name(routeName)
                .build();

        Route saved = repository.save(newRoute);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(saved));
    }

    @Override
    public double calculateDistance(Address from, Address to) {
        if (from == null || to == null) return 0.0;
        if (from.getLatitude() == null || from.getLongitude() == null
            || to.getLatitude() == null || to.getLongitude() == null) {
            return 0.0;
        }

        double lat1 = from.getLatitude();
        double lon1 = from.getLongitude();
        double lat2 = to.getLatitude();
        double lon2 = to.getLongitude();

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                   + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                     * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Math.round(EARTH_RADIUS_KM * c * 100.0) / 100.0; // 2 decimal places
    }

    @Override
    public LocalTime calculateEstimateTime(double distance) {
        if (distance <= 0) return null;
        double hours = distance / AVERAGE_SPEED;
        long totalSeconds = (long) (hours * 3600);
        // Agar 24 soatdan katta bo‘lsa, LocalTime ishlamay qoladi!
        return (totalSeconds < 24 * 3600)
                ? LocalTime.ofSecondOfDay(totalSeconds)
                : LocalTime.MIDNIGHT; // yoki null, yoki Duration ishlatish mumkin
    }

    @Override
    public String generateRouteName(Address from, Address to) {
        String fromName = (from != null && from.getDistrict() != null)
                ? from.getDistrict().getNameUz() : "Unknown";
        String toName = (to != null && to.getDistrict() != null)
                ? to.getDistrict().getNameUz() : "Unknown";

        return fromName + " - " + toName;
    }

    @Override
    public Response<RouteResponseDTO> update(UpdateRouteDTO dto) {

        return null;
    }

    @Override
    public Response<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public Response<RouteResponseDTO> find(Long id) {
        return null;
    }

    @Override
    public Response<List<RouteResponseDTO>> findAll() {
        return null;
    }
}
