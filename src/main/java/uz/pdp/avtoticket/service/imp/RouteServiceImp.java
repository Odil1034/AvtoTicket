package uz.pdp.avtoticket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateRouteDTO;
import uz.pdp.avtoticket.dto.request.UpdateRouteDTO;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;
import uz.pdp.avtoticket.dto.response.RouteResponseDTO;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.Route;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.mapper.RouteMapper;
import uz.pdp.avtoticket.repository.RouteRepository;
import uz.pdp.avtoticket.repository.address.DistrictRepository;
import uz.pdp.avtoticket.service.AddressService;
import uz.pdp.avtoticket.service.RouteService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.text.MessageFormat;
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

    private final DistrictRepository districtRepository;
    private final AddressService addressService;

    public RouteServiceImp(RouteRepository repository, RouteMapper mapper,
                           DistrictRepository districtRepository, AddressService addressService) {
        super(repository, mapper);
        this.districtRepository = districtRepository;
        this.addressService = addressService;
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
        Address toAddress = addressService.buildAndSaveAddress(dto.toAddress());
        Address fromAddress = addressService.buildAndSaveAddress(dto.fromAddress());

        double distance = calculateDistance(fromAddress, toAddress);
        String estimateTime = calculateEstimateTime(distance);
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

    public String calculateEstimateTime(double distance) {
        if (distance <= 0) return null;
        double hours = distance / AVERAGE_SPEED;
        long totalSeconds = (long) (hours * 3600);
        long days = totalSeconds / 86400;
        long hoursPart = (totalSeconds % 86400) / 3600;
        long minutesPart = (totalSeconds % 3600) / 60;
        long secondsPart = totalSeconds % 60;
        return String.format("%d days %02d:%02d:%02d", days, hoursPart, minutesPart, secondsPart);
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
        Route route = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id {0}", dto.id()));

        Address toAddress = route.getToAddress();
        Address fromAddress = route.getFromAddress();

        updateAddress(toAddress, dto.toAddress());
        updateAddress(fromAddress, dto.fromAddress());

        double newDistance = calculateDistance(toAddress, fromAddress);
        String newEstimateTime = calculateEstimateTime(newDistance);
        String newRouteName = generateRouteName(fromAddress, toAddress);

        route.setEstimateTime(newEstimateTime);
        route.setDistance(newDistance);
        route.setName(newRouteName);

        Route savedRoute = repository.save(route);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(savedRoute));
    }

    private void updateAddress(Address address, CreateAddressDTO dto) {
        District district = districtRepository.findByIdCustom(dto.districtId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id {0}", dto.districtId()));
        address.setDistrict(district);
        address.setRegion(district.getRegion());
        address.setCountry(district.getRegion().getCountry());
        address.setLongitude(dto.longitude());
        address.setLatitude(dto.latitude());
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.deleteByIdCustom(id);
        return Response.ok(200, true, MessageFormat.format("Route is deleted with id{0} ✔✔✔", id));
    }

    @Override
    public Response<RouteResponseDTO> find(Long id) {
        Route route = repository.findByIdCustom(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id {0}", id));
        return Response.ok(mapper.toDto(route));
    }

    @Override
    public Response<List<RouteResponseDTO>> findAll() {
        return null;
    }
}
