package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.AutoTicket.dto.request.CreateRouteDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRouteDTO;
import uz.pdp.AutoTicket.dto.response.RouteResponseDTO;
import uz.pdp.AutoTicket.entity.Route;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 22:27
 */
@Mapper(componentModel = "spring")
public interface RouteMapper extends GenericMapper<Route, RouteResponseDTO, CreateRouteDTO, UpdateRouteDTO> {
}
