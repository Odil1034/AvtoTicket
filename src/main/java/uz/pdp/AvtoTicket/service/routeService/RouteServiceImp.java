package uz.pdp.AvtoTicket.service.routeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.CreateRouteDTO;
import uz.pdp.AvtoTicket.dto.response.RouteDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRouteDTO;
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
    public RouteDTO create(CreateRouteDTO dto) {
        Route entity = routeMapper.toEntity(dto);
        Route save = routeRepository.save(entity);
        return routeMapper.toDTO(save);
    }

    @Override
    public RouteDTO getById(Long id) {
        Route byId = findById(id);
        return routeMapper.toDTO(byId);
    }

    @Override
    public List<RouteDTO> getAll() {
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
    public RouteDTO update(Long routeId, UpdateRouteDTO dto) {
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
