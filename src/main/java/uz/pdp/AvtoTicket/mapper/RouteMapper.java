package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.route.RouteResponseDTO;
import uz.pdp.AvtoTicket.dto.route.CreateRouteDTO;
import uz.pdp.AvtoTicket.dto.route.UpdateRouteDTO;
import uz.pdp.AvtoTicket.entity.route.Route;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    Route toEntity(CreateRouteDTO dto);

    Route toEntity(RouteResponseDTO dto);

    RouteResponseDTO toDTO(Route route);

    List<RouteResponseDTO> toDTOList(List<Route> route);

    void toUpdate(@MappingTarget Route route, UpdateRouteDTO dto);
}
