package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.response.RouteDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateRouteDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRouteDTO;
import uz.pdp.AvtoTicket.entity.route.Route;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    Route toEntity(CreateRouteDTO dto);

//    Route toEntity(RouteDTO dto);

    RouteDTO toDTO(Route route);

    List<RouteDTO> toDTOList(List<Route> route);

    void toUpdate(@MappingTarget Route route, UpdateRouteDTO dto);
}
