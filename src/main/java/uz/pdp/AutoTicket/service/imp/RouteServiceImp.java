package uz.pdp.AutoTicket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRouteDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRouteDTO;
import uz.pdp.AutoTicket.dto.response.RouteResponseDTO;
import uz.pdp.AutoTicket.entity.Route;
import uz.pdp.AutoTicket.mapper.RouteMapper;
import uz.pdp.AutoTicket.repository.RouteRepository;
import uz.pdp.AutoTicket.service.RouteService;
import uz.pdp.AutoTicket.service.markers.AbstractService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 22:26
 */

@Service
public class RouteServiceImp extends AbstractService<RouteRepository, RouteMapper> implements RouteService {

    public RouteServiceImp(RouteRepository repository, RouteMapper mapper) {
        super(repository, mapper);
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
        Route route = mapper.fromCreate(dto);
        System.out.println(route);
        Route save = repository.save(route);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(save));
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
