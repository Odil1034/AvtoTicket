package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.CreateRouteDTO;
import uz.pdp.avtoticket.dto.request.UpdateRouteDTO;
import uz.pdp.avtoticket.dto.response.RouteResponseDTO;
import uz.pdp.avtoticket.entity.Route;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 22:27
 */
@Mapper(componentModel = "spring")
public interface RouteMapper extends GenericMapper<Route, RouteResponseDTO, CreateRouteDTO, UpdateRouteDTO> {
}
