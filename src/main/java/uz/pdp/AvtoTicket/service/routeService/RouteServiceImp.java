package uz.pdp.AvtoTicket.service.routeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.route.CreateRouteDTO;
import uz.pdp.AvtoTicket.dto.route.RouteResponseDTO;
import uz.pdp.AvtoTicket.dto.route.UpdateRouteDTO;
import uz.pdp.AvtoTicket.entity.route.Route;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.RouteMapper;
import uz.pdp.AvtoTicket.repository.RouteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImp implements RouteService {

    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;

    @Override
    public RouteResponseDTO create(CreateRouteDTO dto) {
        Route entity = routeMapper.toEntity(dto);
        Route save = routeRepository.save(entity);
        return routeMapper.toDTO(save);
    }

    @Override
    public RouteResponseDTO getById(Long id) {
        Route byId = findById(id);
        return routeMapper.toDTO(byId);
    }

    @Override
    public List<RouteResponseDTO> getAll() {
        List<Route> all = routeRepository.findAll();
        return routeMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Route byId = findById(id);
        byId.setDeleted(true);
        routeRepository.save(byId);
        return true;
    }

    @Override
    public RouteResponseDTO update(Long routeId, UpdateRouteDTO dto) {
        Route byId = findById(routeId);
        routeMapper.toUpdate(byId, dto);
        Route save = routeRepository.save(byId);
        return routeMapper.toDTO(save);
    }

    @Override
    public Route findById(Long routeId) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new NotFoundException("Route not found with id : " + routeId));
        if (!route.isDeleted()) {
            return route;
        } else {
            throw new IsDeletedException("Route is deleted with id = " + routeId);
        }
    }
}
