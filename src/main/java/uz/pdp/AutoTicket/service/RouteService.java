package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateRouteDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRouteDTO;
import uz.pdp.AutoTicket.dto.response.RouteResponseDTO;
import uz.pdp.AutoTicket.entity.Route;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:56
 */
public interface RouteService
        extends GenericCruidService<Long, Route, RouteResponseDTO, CreateRouteDTO, UpdateRouteDTO> {
}
