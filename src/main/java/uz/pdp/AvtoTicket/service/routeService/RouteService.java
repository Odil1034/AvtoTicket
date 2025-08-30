package uz.pdp.AvtoTicket.service.routeService;

import uz.pdp.AvtoTicket.dto.request.create.CreateRouteDTO;
import uz.pdp.AvtoTicket.dto.response.RouteDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRouteDTO;
import uz.pdp.AvtoTicket.entity.route.Route;
import uz.pdp.AvtoTicket.service.BaseService;

public interface RouteService extends BaseService<Route, CreateRouteDTO, UpdateRouteDTO, RouteDTO> {

}
