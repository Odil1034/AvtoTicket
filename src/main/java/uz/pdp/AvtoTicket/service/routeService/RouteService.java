package uz.pdp.AvtoTicket.service.routeService;

import uz.pdp.AvtoTicket.dto.route.CreateRouteDTO;
import uz.pdp.AvtoTicket.dto.route.RouteResponseDTO;
import uz.pdp.AvtoTicket.dto.route.UpdateRouteDTO;
import uz.pdp.AvtoTicket.entity.route.Route;
import uz.pdp.AvtoTicket.service.BaseService;

public interface RouteService extends BaseService<Route, CreateRouteDTO, UpdateRouteDTO, RouteResponseDTO> {

}
